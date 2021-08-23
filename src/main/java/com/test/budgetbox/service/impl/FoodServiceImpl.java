package com.test.budgetbox.service.impl;

import com.test.budgetbox.entity.Food;
import com.test.budgetbox.repository.FoodRepository;
import com.test.budgetbox.service.FoodService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	private final FoodRepository foodRepository;

	public FoodServiceImpl(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	public Food findById(int id) {
		Optional<Food> food = foodRepository.findById(id);
		return food.orElse(null);
	}

	public List<Food> findAll() {
		return foodRepository.findAll();
	}

	public Food save(Food food) {
		return foodRepository.save(food);
	}

	public void delete(Food food) {
		foodRepository.delete(food);
	}
}
