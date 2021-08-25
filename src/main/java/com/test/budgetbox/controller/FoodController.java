package com.test.budgetbox.controller;

import com.test.budgetbox.entity.Food;
import com.test.budgetbox.service.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping("food")
@Transactional
public class FoodController extends AbstractController{

	private final FoodService foodService;

	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable int id) {
		return foodService.findById(id);
	}

	@GetMapping("/all")
	public Page<Food> geFoods(@RequestParam(name = "pageNumber", defaultValue = DEFAULT_PAGE_NUMBER) int pageNumber,
	                              @RequestParam(name = "pageSize", defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return foodService.findAll(pageable);
	}

	@GetMapping("/search")
	public Page<Food> searchFood(@RequestParam(name = "name") String name,
	                             @RequestParam(name = "pageNumber", defaultValue = DEFAULT_PAGE_NUMBER) int pageNumber,
	                             @RequestParam(name = "pageSize", defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return foodService.findByName(name, pageable);
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
