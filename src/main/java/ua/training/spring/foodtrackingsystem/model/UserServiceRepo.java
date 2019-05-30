package ua.training.spring.foodtrackingsystem.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class UserServiceRepo {
    @Autowired
    private UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
