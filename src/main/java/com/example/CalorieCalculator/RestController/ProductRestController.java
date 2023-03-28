package com.example.CalorieCalculator.RestController;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.Product;
import com.example.CalorieCalculator.Service.MealService;
import com.example.CalorieCalculator.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {



    @Autowired
    private ProductService productService;


    @PostMapping("/products/")

    public Product createProduct (@RequestBody Product product){


        return productService.createProduct(product);
    }

    @GetMapping("/products/")

    public List<Product> findAllProducts (){


        return productService.findAll();
    }







}
