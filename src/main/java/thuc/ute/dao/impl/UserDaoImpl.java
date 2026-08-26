package thuc.ute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import thuc.ute.dao.IUserDao;
import thuc.ute.models.UserModel;
import thuc.ute.utils.DBConnection;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {

		String sql = "SELECT * FROM Users";

		List<UserModel> list = new ArrayList<>();

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				UserModel user = new UserModel();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));

				list.add(user);
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {

		String sql = "SELECT * FROM Users WHERE id = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				UserModel user = new UserModel();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findByUserName(String username) {

		String sql = "SELECT * FROM Users WHERE username = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {

				UserModel user = new UserModel();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO Users "
				+ "(email, username, fullname, password, avatar, roleid, phone, createdDate) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedDate());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {

		boolean duplicate = false;

		String sql = "SELECT * FROM Users WHERE email = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				duplicate = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {

		boolean duplicate = false;

		String sql = "SELECT * FROM Users WHERE username = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {
				duplicate = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {

		boolean duplicate = false;

		String sql = "SELECT * FROM Users WHERE phone = ?";

		try {

			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, phone);

			rs = ps.executeQuery();

			if (rs.next()) {
				duplicate = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return duplicate;
	}
	public static void main(String[] argns) {
		IUserDao userDao = new UserDaoImpl();
		System.out.println(userDao.findByUserName("thuc"));
	}
}
