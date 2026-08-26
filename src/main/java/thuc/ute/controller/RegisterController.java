package thuc.ute.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thuc.ute.services.IUserService;
import thuc.ute.services.impl.UserServiceImpl;
import thuc.ute.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private final IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					session = req.getSession(true);
					session.setAttribute(Constant.SESSION_USERNAME, cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}

		req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");

		keepFormValues(req, username, email, fullname, phone);

		if (isBlank(username) || isBlank(password) || isBlank(confirmPassword) || isBlank(email)
				|| isBlank(fullname) || isBlank(phone)) {
			req.setAttribute("alert", "Vui long nhap day du thong tin!");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		if (!password.equals(confirmPassword)) {
			req.setAttribute("alert", "Mat khau nhap lai khong khop!");
			req.setAttribute("fieldError", "confirmPassword");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		if (service.checkExistEmail(email)) {
			req.setAttribute("alert", "Email da ton tai!");
			req.setAttribute("fieldError", "email");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		if (service.checkExistUsername(username)) {
			req.setAttribute("alert", "Username da duoc su dung!");
			req.setAttribute("fieldError", "username");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		if (service.checkExistPhone(phone)) {
			req.setAttribute("alert", "So dien thoai da ton tai!");
			req.setAttribute("fieldError", "phone");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		boolean isSuccess = service.register(email, password, username, fullname, phone);
		if (isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			req.setAttribute("alert", "System error!");
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
		}
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private void keepFormValues(HttpServletRequest req, String username, String email, String fullname, String phone) {
		req.setAttribute("usernameValue", username);
		req.setAttribute("emailValue", email);
		req.setAttribute("fullnameValue", fullname);
		req.setAttribute("phoneValue", phone);
	}
}
