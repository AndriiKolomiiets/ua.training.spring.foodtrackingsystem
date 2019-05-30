package ua.training.spring.foodtrackingsystem.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLogin(String login);

}
