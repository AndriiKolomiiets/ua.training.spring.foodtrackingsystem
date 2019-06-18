package ua.training.spring.foodtrackingsystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.spring.foodtrackingsystem.model.domain.Food;
import ua.training.spring.foodtrackingsystem.model.domain.User;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findFoodByFoodName(String foodName);


    List<Food> findAllByCalories(String calories);
}
