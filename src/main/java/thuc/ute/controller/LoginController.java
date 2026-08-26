package thuc.ute.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thuc.ute.models.UserModel;
import thuc.ute.services.IUserService;
import thuc.ute.services.impl.UserServiceImpl;
import thuc.ute.utils.Constant;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 938943060486107506L;
	private final IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		boolean isRememberMe = "on".equals(req.getParameter("remember"));

		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			req.setAttribute("alert", "Tai khoan hoac mat khau khong duoc rong");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRememberMe(resp, username);
			}

			req.setAttribute("name", user.getFullname() != null ? user.getFullname() : user.getUsername());
			resp.sendRedirect(req.getContextPath() +"/waiting");
		} else {
			req.setAttribute("alert", "Tai khoan hoac mat khau khong dung");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);
	}
}
