package com.roney.expensetracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roney.expensetracker.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public Optional<Category> findByNameAndUserId(String name,int userId);
	public Optional<List<Category>> findAllByUserId(int userId);
}
