package thuc.ute.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import thuc.ute.models.CategoryModel;
import thuc.ute.services.ICategoryService;
import thuc.ute.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		req.getRequestDispatcher("/views/admin/add-category.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String categoryname =
				req.getParameter("categoryname");

		String images =
				req.getParameter("images");

		String statusParam =
				req.getParameter("status");

		int status = 1;

		if (statusParam != null && !statusParam.isEmpty()) {
			status = Integer.parseInt(statusParam);
		}

		CategoryModel category =
				new CategoryModel();

		category.setCategoryname(categoryname);
		category.setImages(images);
		category.setStatus(status);

		cateService.insert(category);

		resp.sendRedirect(
				req.getContextPath()
				+ "/admin/category/list"
		);
	}
}