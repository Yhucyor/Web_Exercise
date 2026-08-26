package thuc.ute.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import thuc.ute.models.CategoryModel;
import thuc.ute.services.ICategoryService;
import thuc.ute.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		List<CategoryModel> cateList = cateService.getAll();

		req.setAttribute("cateList", cateList);

		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/list-category.jsp");

		dispatcher.forward(req, resp);
	}
}