package com.test.budgetbox.service;

import com.test.budgetbox.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FoodService {

	Food findById(int id);

	Page<Food> findAll(Pageable pageable);

	Page<Food> findByName(String name, Pageable pageable);

	Food save(Food food);

	void delete(Food food);
}

