package com.roney.expensetracker.service;

import java.util.List;

import com.roney.expensetracker.dto.CategoryDto;
import com.roney.expensetracker.entities.Category;

public interface CategoryService {

	public Category createCategory(CategoryDto catDto);
	public Category updateCategory(CategoryDto catDto);
	public Category deleteCategory(CategoryDto catDto);
	public List<Category> findCategoryByUser(int userId);
	public Category findCategoryById(int id);
}
