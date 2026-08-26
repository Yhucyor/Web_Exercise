package thuc.ute.services.impl;

import java.util.List;

import thuc.ute.dao.ICategoryDao;
import thuc.ute.dao.impl.CategoryDaoImpl;
import thuc.ute.models.CategoryModel;
import thuc.ute.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void edit(CategoryModel newCategory) {

		CategoryModel oldCategory =
				categoryDao.get(newCategory.getCategoryid());

		oldCategory.setCategoryname(
				newCategory.getCategoryname());

		if (newCategory.getImages() != null) {
			oldCategory.setImages(
					newCategory.getImages());
		}

		oldCategory.setStatus(
				newCategory.getStatus());

		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public CategoryModel get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<CategoryModel> search(String keyword) {
		return categoryDao.search(keyword);
	}
}