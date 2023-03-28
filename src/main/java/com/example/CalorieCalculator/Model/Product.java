package com.example.CalorieCalculator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productName;

    private int productCalories;


    @JsonIgnore
    @ManyToMany(mappedBy = "productList")
    private List<Meal> mealList;




}
