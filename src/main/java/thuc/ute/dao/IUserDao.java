package thuc.ute.dao;

import java.util.List;

import thuc.ute.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int id);

	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
