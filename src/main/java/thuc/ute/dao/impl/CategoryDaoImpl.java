package thuc.ute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import thuc.ute.dao.ICategoryDao;
import thuc.ute.models.CategoryModel;
import thuc.ute.utils.DBConnection;

public class CategoryDaoImpl extends DBConnection implements ICategoryDao {

	@Override
	public void insert(CategoryModel category) {

		String sql = "INSERT INTO Categories(categoryname, images, status) VALUES (?, ?, ?)";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CategoryModel category) {

		String sql = "UPDATE Categories "
				+ "SET categoryname = ?, images = ?, status = ? "
				+ "WHERE categoryid = ?";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM Categories WHERE categoryid = ?";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel get(int id) {

		String sql = "SELECT * FROM Categories WHERE categoryid = ?";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				CategoryModel category = new CategoryModel();

				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				return category;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CategoryModel get(String name) {

		String sql = "SELECT * FROM Categories WHERE categoryname = ?";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				CategoryModel category = new CategoryModel();

				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				return category;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<CategoryModel> getAll() {

		List<CategoryModel> categories = new ArrayList<CategoryModel>();

		String sql = "SELECT * FROM Categories";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				CategoryModel category = new CategoryModel();

				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				categories.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public List<CategoryModel> search(String keyword) {

		List<CategoryModel> categories = new ArrayList<CategoryModel>();

		String sql = "SELECT * FROM Categories WHERE categoryname LIKE ?";

		try {

			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				CategoryModel category = new CategoryModel();

				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

				categories.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}
}
