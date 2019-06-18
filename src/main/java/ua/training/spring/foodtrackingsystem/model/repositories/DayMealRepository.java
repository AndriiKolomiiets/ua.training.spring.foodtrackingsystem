package ua.training.spring.foodtrackingsystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.DayMeal;
import ua.training.spring.foodtrackingsystem.model.domain.User;

import java.util.List;

public interface DayMealRepository extends JpaRepository<DayMeal, Long> {
    DayMeal findByClient(Client client);
    DayMeal findById(long id);
    List<DayMeal> findAllByClient(Client client);


    void deleteById(long id);
}
