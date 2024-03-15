package com.roney.expensetracker.serviceimpliment;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.roney.expensetracker.Exceptions.CustomResourceNotFoundException;
import com.roney.expensetracker.Exceptions.ExistingResourceException;
import com.roney.expensetracker.Exceptions.InvalidInputException;
import com.roney.expensetracker.dto.CategoryDto;
import com.roney.expensetracker.entities.Category;
import com.roney.expensetracker.repositories.CategoryRepository;
import com.roney.expensetracker.service.CategoryService;
import com.roney.expensetracker.utilities.ServiceUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository catRepo;
	private ModelMapper mapper;

	public CategoryServiceImpl(CategoryRepository catRepo, ModelMapper mapper) {
		this.catRepo = catRepo;
		this.mapper = mapper;
	}

	@Override
	public Category createCategory(CategoryDto catDto) {

		if (ServiceUtil.isEmpty(catDto))
			throw new InvalidInputException();
		catDto.setName(catDto.getName().toLowerCase());
		Optional<Category> optional = catRepo.findByNameAndUserId(catDto.getName(), catDto.getUserId());
		if (optional.isPresent())
			throw new ExistingResourceException();

		return catRepo.save(mapper.map(catDto, Category.class));
	}

	@Override
	public Category updateCategory(CategoryDto catDto) {
		if (ServiceUtil.isEmpty(catDto))
			throw new InvalidInputException();

		catDto.setName(catDto.getName().toLowerCase());
		Optional<Category> optional = catRepo.findById(catDto.getCategoryId());
		if (optional.isEmpty())
			throw new CustomResourceNotFoundException();
		Category category = optional.get();
		mapper.map(catDto, category);
		return catRepo.save(category);
	}

	@Override
	public Category deleteCategory(CategoryDto catDto) {
		if (ServiceUtil.isEmpty(catDto))
			throw new InvalidInputException();

		Optional<Category> optional = catRepo.findById(catDto.getCategoryId());
		if (optional.isEmpty())
			throw new CustomResourceNotFoundException();
		catRepo.delete(optional.get());
		return optional.get();
	}

	@Override
	public List<Category> findCategoryByUser(int userId) {

		Optional<List<Category>> catList = catRepo.findAllByUserId(userId);
		if (catList.isEmpty())
			throw new CustomResourceNotFoundException();
		return catList.get();
	}

	@Override
	public Category findCategoryById(int id) {

		Optional<Category> optional = catRepo.findById(id);
		if (optional.isEmpty())
			throw new CustomResourceNotFoundException();
		return optional.get();
	}

}
