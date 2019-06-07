package ua.training.spring.foodtrackingsystem.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findById(long id);
    void deleteById(long id);


}