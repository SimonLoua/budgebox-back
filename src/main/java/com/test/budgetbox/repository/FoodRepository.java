package com.test.budgetbox.repository;

import com.test.budgetbox.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	@Query("Select food from Food food WHERE food.name LIKE CONCAT('%', :name, '%')")
	Page<Food> findByName(@Param("name") String name, Pageable pageable);

}
