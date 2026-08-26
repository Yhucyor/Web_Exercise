package thuc.ute.services.impl;

import java.sql.Date;

import thuc.ute.dao.IUserDao;
import thuc.ute.dao.impl.UserDaoImpl;
import thuc.ute.models.UserModel;
import thuc.ute.services.IUserService;

public class UserServiceImpl implements IUserService {
	// Lấy toàn bộ hàm trong tầng DAO của User 
	
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		UserModel user = new UserModel(email, username, fullname, password, null, 5, phone, date);
		userDao.insert(user);

		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

}
