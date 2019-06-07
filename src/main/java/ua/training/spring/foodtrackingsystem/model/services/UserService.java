package ua.training.spring.foodtrackingsystem.model.services;

import ua.training.spring.foodtrackingsystem.exceptions.NotFoundException;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   /* Optional<User> findByUsername(String name);*/
    User findByUsername(String name);
    boolean addUser(User user);
    void setClient(String username, Client client) throws NotFoundException;
    List<User> findAll();

    User findById(Long id);
    void deleteUser(long id);
    Client getClientByUserId(long id);
    User getUserById(long id);
    void deleteClientInfo(long id);
    void addClientInfo(long id, Client client);
    void addClientInfo(User user, Client client);
}