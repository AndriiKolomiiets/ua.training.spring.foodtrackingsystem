package ua.training.spring.foodtrackingsystem.model.services;

import ua.training.spring.foodtrackingsystem.model.domain.User;

public interface UserService {
    User findByUsername(String name);
    boolean addUser(User user);
}