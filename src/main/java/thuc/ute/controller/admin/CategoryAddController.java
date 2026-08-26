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

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig
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
