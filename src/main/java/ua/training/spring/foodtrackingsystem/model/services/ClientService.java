package ua.training.spring.foodtrackingsystem.model.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ua.training.spring.foodtrackingsystem.exceptions.NotFoundException;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

import javax.persistence.Id;
import java.util.Optional;

public class ClientService {
    @Autowired
    User user;
    @Autowired
    Client client;
    @Autowired
    Session session;
    @Autowired
    UserRepository userRepository;

    public void setClient(Client client) {
        user.setClient(client);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addClientInfo(User user, Client client) {
        user.setClient(client);
        userRepository.save(user);
    }

    public void addClientInfo(long id, Client client){
        userRepository.findById(id).setClient(client);
        userRepository.save(user);
    }

    public Client getClientByUserId(long id){
        user = userRepository.findById(id);
        return user.getClient();
    }

    public User getUserById(long id){
        Optional <User> optionalUser = Optional.ofNullable(userRepository.findById(id));
        return optionalUser.orElseThrow(NotFoundException::new);
    }
}
