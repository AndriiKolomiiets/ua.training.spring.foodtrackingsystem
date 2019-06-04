package ua.training.spring.foodtrackingsystem.model.services;

import ua.training.spring.foodtrackingsystem.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

//todo: switched this bean
//@Component
public class UserServiceTest implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }
}