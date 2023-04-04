package com.example.CalorieCalculator.RestController;

import com.example.CalorieCalculator.Model.User;
import com.example.CalorieCalculator.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired UserService userService;

    @GetMapping("/users/")
    public List<User> getAllUsers(){


        return userService.getAllUsers();

    }

    @PostMapping("/users/")
    public User addUser (@RequestBody User user){

        return userService.addUser(user);

    }

    @PutMapping("/addFavoriteMeal/{userName}/{mealName}/")
    public User addFavoriteMeal(@PathVariable ("mealName") String mealName, @PathVariable ("userName") String userName){


        return userService.addFavoriteMeal(mealName, userName);

    }




}
