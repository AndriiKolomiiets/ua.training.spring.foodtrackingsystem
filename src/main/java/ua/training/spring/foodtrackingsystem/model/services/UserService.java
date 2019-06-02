package ua.training.spring.foodtrackingsystem.model.services;

import ua.training.spring.foodtrackingsystem.model.User;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
}