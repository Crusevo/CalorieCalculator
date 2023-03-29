package com.example.CalorieCalculator.RestController;

import com.example.CalorieCalculator.Model.User;
import com.example.CalorieCalculator.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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




}
