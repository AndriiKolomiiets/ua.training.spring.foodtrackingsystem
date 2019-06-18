package ua.training.spring.foodtrackingsystem.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.DayMeal;
import ua.training.spring.foodtrackingsystem.model.repositories.DayMealRepository;

@Service
public class AddMealService {
    @Autowired
    DayMealRepository repository;
    public void addMeal(Client client, DayMeal meal){
       /* meal.setCaloriesStatus();
meal.setCaloriesToNorm();
meal.setDateTime();*/

        meal.setClient(client);
        repository.save(meal);
    }

}
