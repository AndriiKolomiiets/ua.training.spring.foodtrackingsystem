package ua.training.spring.foodtrackingsystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.spring.foodtrackingsystem.model.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);
}