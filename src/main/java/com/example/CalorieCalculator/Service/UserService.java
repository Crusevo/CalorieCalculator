package com.example.CalorieCalculator.Service;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Model.User;
import com.example.CalorieCalculator.Repository.MealRepository;
import com.example.CalorieCalculator.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MealRepository mealRepository;

    public List<User> getAllUsers(){

        return userRepository.findAll();


    }


    public User addUser(User user) {

        List<User> userNameFromDatabase = userRepository.findByUserName(user.getUserName());



        if(userNameFromDatabase.isEmpty()){

            userRepository.save(user);


        } else {

            System.out.println("Uźytkownik jest już w bazie danych");

        }

        return user;

    }

    public User addFavoriteMeal(String mealName, String userName) {

        List<Meal> mealFromDatabaseList = mealRepository.findByMealName(mealName);

        List<User> userFromDatabaseList = userRepository.findByUserName(userName);


        Meal mealFromDatabase = mealFromDatabaseList.get(0);

        User userFromDatabase = userFromDatabaseList.get(0);

        List<Meal> userFromDatabaseFavoriteMeal = userFromDatabase.getFavoriteMeal();

        List<User> mealFromDatabaseUserList = mealFromDatabase.getUserList();


        if(mealFromDatabaseList.isEmpty()){

            System.out.println("W bazie danych brak produktu o tej nazwie");



        } else if (!userFromDatabaseFavoriteMeal.contains(mealFromDatabase)){


            userFromDatabaseFavoriteMeal.add(mealFromDatabase);

            mealFromDatabaseUserList.add(userFromDatabase);

            userRepository.save(userFromDatabase);

            mealRepository.save(mealFromDatabase);



        } else {


            System.out.println("Posiłek jest już w ulubionych");

        }


        return userFromDatabase;


    }
}
