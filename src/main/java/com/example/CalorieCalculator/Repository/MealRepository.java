package com.example.CalorieCalculator.Repository;

import com.example.CalorieCalculator.Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository  extends JpaRepository<Meal, Long> {



    @Query
    List<Meal> findByMealName(String mealName);
}
