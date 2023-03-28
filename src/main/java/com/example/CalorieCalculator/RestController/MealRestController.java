package com.example.CalorieCalculator.RestController;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.Product;
import com.example.CalorieCalculator.Service.MealService;
import com.example.CalorieCalculator.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealRestController {

    @Autowired
    private MealService mealService;

    @Autowired
    private ProductService productService;


    @PostMapping("/meals/")
    public Meal createMeal(@RequestBody Meal meal){


        return mealService.createMeal(meal);

    }


    @PutMapping("/meals/{mealName}/")
    public Product addProductToMeal(@RequestBody Product product, @PathVariable ("mealName") String mealName){



        return mealService.addProductToMeal(mealName, product);



    }

    @GetMapping("/meals/")
    public List<Meal> findAllMeals(){


        return mealService.findAllMeals();

    }






//    @GetMapping("/meals/{meal}/")
//    public Meal findByMealName (@PathVariable ("meal") String mealName){
//
//        return mealService.findByName(mealName);
//
//    }


}
