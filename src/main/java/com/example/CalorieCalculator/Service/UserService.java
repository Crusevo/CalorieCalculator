package com.example.CalorieCalculator.Service;

import com.example.CalorieCalculator.Model.User;
import com.example.CalorieCalculator.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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

}
