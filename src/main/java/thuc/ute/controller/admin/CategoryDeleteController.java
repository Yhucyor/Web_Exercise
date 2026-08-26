package thuc.ute.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import thuc.ute.services.ICategoryService;
import thuc.ute.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICategoryService cateService =
			new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");

		if (id != null && !id.isEmpty()) {

			cateService.delete(
					Integer.parseInt(id)
			);
		}

		resp.sendRedirect(
				req.getContextPath()
				+ "/admin/category/list"
		);
	}
}