package ua.training.spring.foodtrackingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

public class Main {
    @Autowired
     User user;
    @Autowired
    static UserRepository userRepository;
    public static void main(String[] args) {
//        user.getUsername();
        userRepository.findAll();
    }

}
