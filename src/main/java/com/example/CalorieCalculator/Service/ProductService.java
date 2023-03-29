package com.example.CalorieCalculator.Service;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.Product;
import com.example.CalorieCalculator.Repository.MealRepository;
import com.example.CalorieCalculator.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product createProduct(Product product){


        List<Product> checkingProductInDatabase = productRepository.findByProductName(product.getProductName());


        if (checkingProductInDatabase.isEmpty()){


            productRepository.save(product);

        } else {


            System.out.println("Produkt o tej nazwie jest już w bazie danych");

        }

        return product;

    }


    public List<Product> findAll() {

        List<Product> allProducts = productRepository.findAll();

        for (int i = 0; i <allProducts.size(); i++){


            System.out.println("Nazwa produktu: " + allProducts.get(i).getProductName());
            System.out.println("Kalorie w 100g: " + allProducts.get(i).getProductCalories());

        }

        return productRepository.findAll();

    }
}
