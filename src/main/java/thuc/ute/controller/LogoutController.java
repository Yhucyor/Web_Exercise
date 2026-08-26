package thuc.ute.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thuc.ute.utils.Constant;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		deleteRememberMe(resp);
		resp.sendRedirect(req.getContextPath() + "/login");
	}

	private void deleteRememberMe(HttpServletResponse resp) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, "");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
	}
}
