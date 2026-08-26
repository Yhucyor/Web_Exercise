package thuc.ute.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thuc.ute.models.UserModel;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	private static final long serialVersionUID = 8815311246228156932L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("account") != null) {
			UserModel user = (UserModel) session.getAttribute("account");
			session.setAttribute("username", user.getUsername());
			session.setAttribute("roleName", getRoleName(user.getRoleid()));

			req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	private String getRoleName(int roleid) {
		if (roleid == 1) {
			return "Admin";
		}
		if (roleid == 2) {
			return "Manager";
		}
		return "User";
	}
}
