package com.example.CalorieCalculator.Repository;

import com.example.CalorieCalculator.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    List<User> findByUserName(String userName);




}
