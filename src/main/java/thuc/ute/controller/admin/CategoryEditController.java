package thuc.ute.controller.admin;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import com.cloudinary.utils.ObjectUtils;

import thuc.ute.models.CategoryModel;
import thuc.ute.services.ICategoryService;
import thuc.ute.services.impl.CategoryServiceImpl;
import thuc.ute.utils.CloudinaryUtil;

@WebServlet(urlPatterns = { "/admin/category/edit" })
@MultipartConfig
public class CategoryEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");

		if (id == null || id.isEmpty()) {

			resp.sendRedirect(
					req.getContextPath()
					+ "/admin/category/list"
			);

			return;
		}

		CategoryModel category =
				cateService.get(
						Integer.parseInt(id)
				);

		if (category == null) {

			resp.sendRedirect(
					req.getContextPath()
					+ "/admin/category/list"
			);

			return;
		}

		req.setAttribute("category", category);

		req.getRequestDispatcher(
				"/views/admin/edit-category.jsp"
		).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(
				req.getParameter("id")
		);

		String categoryname =
				req.getParameter("categoryname");

		String images = null;
		Part imagePart = req.getPart("images");

		if (imagePart != null && imagePart.getSize() > 0) {
			Map uploadResult = CloudinaryUtil
					.getCloudinary()
					.uploader()
					.upload(
							imagePart.getInputStream().readAllBytes(),
							ObjectUtils.asMap("folder", "categories")
					);

			images = uploadResult.get("secure_url").toString();
		}

		int status = Integer.parseInt(
				req.getParameter("status")
		);

		CategoryModel category =
				new CategoryModel();

		category.setCategoryid(id);
		category.setCategoryname(categoryname);
		category.setImages(images);
		category.setStatus(status);

		cateService.edit(category);

		resp.sendRedirect(
				req.getContextPath()
				+ "/admin/category/list"
		);
	}
}
