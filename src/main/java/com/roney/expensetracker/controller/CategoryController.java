package com.roney.expensetracker.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roney.expensetracker.dto.CategoryDto;
import com.roney.expensetracker.entities.Category;
import com.roney.expensetracker.service.CategoryService;
import com.roney.expensetracker.utilities.ToListMapper;

@RestController
@RequestMapping("/expensetracker/v1/category")
public class CategoryController {

	private CategoryService catService;
	private ModelMapper mapper;
	private ToListMapper listMapper;

	public CategoryController(CategoryService service, ModelMapper mapper, ToListMapper listMapper) {
		this.mapper = mapper;
		this.catService = service;
		this.listMapper = listMapper;
	}

	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto) {

		Category category = catService.createCategory(catDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(category, CategoryDto.class));
	}

	@PostMapping("/update")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto) {
		Category category = catService.updateCategory(catDto);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(category, CategoryDto.class));
	}

	@PostMapping("/delete")
	public ResponseEntity<CategoryDto> deleteCategory(@RequestBody CategoryDto catDto) {
		Category category = catService.deleteCategory(catDto);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(category, CategoryDto.class));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<CategoryDto>> findAllCategories(@PathVariable int userId) {
		List<Category> catList = catService.findCategoryByUser(userId);

		List<CategoryDto> dtoList = listMapper.mapList(catList, CategoryDto.class);

		return ResponseEntity.status(HttpStatus.OK).body(dtoList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> findCategoryById(@PathVariable int id) {
		Category category = catService.findCategoryById(id);

		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(category, CategoryDto.class));
	}

}
