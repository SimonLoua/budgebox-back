package com.test.budgetbox.controller;

import com.test.budgetbox.entity.Food;
import com.test.budgetbox.service.FoodService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("food")
@Transactional
public class FoodController {

	private final FoodService foodService;

	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable int id) {
		return foodService.findById(id);
	}

	@GetMapping("/all")
	public List<Food> geFoods() {
		return foodService.findAll();
	}

	@PostMapping("/save")
	public Food createFood(@RequestBody Food food) {
		return foodService.save(food);
	}

	@PutMapping("/update")
	public Food updateFood(@RequestBody Food food) {
		if(food.getId() > 0) {
			return foodService.save(food);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public boolean deleteFood(@PathVariable int id) {
		Food food = foodService.findById(id);
		if(food != null) {
			foodService.delete(food);
			return true;
		} else {
			return false;
		}
	}
}
