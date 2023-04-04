package com.example.CalorieCalculator;

import com.example.CalorieCalculator.Model.Meal;
import com.example.CalorieCalculator.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class CalorieCalculatorApplication implements CommandLineRunner {

	@Autowired
	MealService mealService;

	public static void main(String[] args) {
		SpringApplication.run(CalorieCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		Random random = new Random();

		System.out.println("Podaj swoje zapotrzebowanie kaloryczne");

		int userCaloriesGoal = scanner.nextInt();
		
		System.out.println("Ile posiłków chcesz jeść dziennie?");

		int howManyMeals = scanner.nextInt();


		List<Meal> allMeals = mealService.findAllMeals();

		boolean isEnd;

		do {

			int randomMealCaloriesSum = 0;

			List<Meal> randomMealList = new ArrayList<>();


			for (int i = 0; i<howManyMeals; i++) {

				Meal randomMealObject;



				int randomMeal = random.nextInt(allMeals.size());

				randomMealObject = allMeals.get(randomMeal);

				int randomMealCalories = allMeals.get(randomMeal).getMealCalories();

				randomMealCaloriesSum += randomMealCalories;

				if (randomMealList.contains(randomMealObject)){

					i--;

				} else {

					randomMealList.add(randomMealObject);

				}




			}



			int result = randomMealCaloriesSum - userCaloriesGoal;

			int resultAbsolute = Math.abs(result);


			if (resultAbsolute < 250){

				System.out.println("Poniżej wyświetliłem posiłki które spełniają twoje dzienne kryteria kaloryczne");

				for (int i = 0; i<randomMealList.size(); i ++){

					System.out.println("Nazwa posiłku: " + randomMealList.get(i).getMealName());
					System.out.println("Kaloryczność posiłku: " + randomMealList.get(i).getMealCalories());

				}

				System.out.println("Suma kalorii: " + randomMealCaloriesSum);

				isEnd = true;

			} else {


				isEnd = false;
			}




		} while (!isEnd);


		


	}
}
