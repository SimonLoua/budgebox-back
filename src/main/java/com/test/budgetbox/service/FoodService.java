package com.test.budgetbox.service;

import com.test.budgetbox.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {

	Food findById(int id);

	List<Food> findAll();

	Food save(Food food);

	void delete(Food food);
}

