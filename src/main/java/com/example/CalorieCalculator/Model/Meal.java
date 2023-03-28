package com.example.CalorieCalculator.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mealName;

    @ManyToMany
    @JoinTable(name = "Meal_Products", joinColumns = @JoinColumn(name = "Meal_Id"),
            inverseJoinColumns = @JoinColumn(name = "Product_Id")
    )
    private List<Product> productList;



}
