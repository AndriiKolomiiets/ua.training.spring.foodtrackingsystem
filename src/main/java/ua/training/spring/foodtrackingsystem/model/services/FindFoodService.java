package ua.training.spring.foodtrackingsystem.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.spring.foodtrackingsystem.model.domain.Food;
import ua.training.spring.foodtrackingsystem.model.repositories.FoodRepository;

import java.util.List;

@Service
public class FindFoodService {
    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }

    public Food findFoodByName(String foodName){
        return foodRepository.findFoodByFoodName(foodName);
    }

}
