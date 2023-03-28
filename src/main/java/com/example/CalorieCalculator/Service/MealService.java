package com.example.CalorieCalculator.Service;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.Product;
import com.example.CalorieCalculator.Repository.MealRepository;
import com.example.CalorieCalculator.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private ProductRepository productRepository;


    public Meal createMeal(Meal meal) {

        List<Meal> checkingMealInDatabase = mealRepository.findByMealName(meal.getMealName());


        if (checkingMealInDatabase.isEmpty()){


            mealRepository.save(meal);

        } else {


            System.out.println("Posiłek o tej nazwie jest już w bazie danych");

        }

        return meal;


    }

    public Product addProductToMeal (String mealName, Product product){

        List<Meal> mealFromDataBaseList = mealRepository.findByMealName(mealName);

        List<Product> productFromDatabaseList = productRepository.findByProductName(product.getProductName());




        if (mealFromDataBaseList.isEmpty()){

            System.out.println("Brak posiłku o tej nazwie w bazie danych");

        } else if (!productFromDatabaseList.isEmpty()) {

            System.out.println("Produkt o tej nazwie jest już w bazie danych (dodano do posiłku)");

            Product productFromDatabase = productFromDatabaseList.get(0);

            product.setId(productFromDatabase.getId());
            product.setProductCalories(productFromDatabase.getProductCalories());
            product.setProductName(productFromDatabase.getProductName());
            product.setMealList(productFromDatabase.getMealList());

            productRepository.save(product);

            Meal mealFromDataBase = mealFromDataBaseList.get(0);

            List<Product> productList = mealFromDataBase.getProductList();

            boolean contains = productList.contains(product);

            if (contains){

                System.out.println("Produkt jest juz przypisany do posiłku");

            } else


            productList.add(product);

            mealRepository.save(mealFromDataBase);

        }


        else if (productFromDatabaseList.isEmpty()){

            Meal mealFromDataBase = mealFromDataBaseList.get(0);

            List<Product> productList = mealFromDataBase.getProductList();

            productRepository.save(product);

            productList.add(product);

            mealRepository.save(mealFromDataBase);

        }




        return product;


    }


    public List <Meal> findAllMeals() {


       return mealRepository.findAll();


    }
}
