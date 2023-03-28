package com.example.CalorieCalculator.Repository;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query
    List<Product> findByProductName(String productName);
}
