package ua.training.spring.foodtrackingsystem.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.training.spring.foodtrackingsystem.exceptions.NotFoundException;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.Role;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


/*    @Override
    public Optional<User> findByUsername(String name) {
        return Optional.ofNullable(userRepository.findByUsername(name));
    }*/

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public boolean addUser(User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            ;/*orElseThrow(NotFoundException::new);*/
            return false;
        }
        user.setAccountStatus(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return true;

    }

    //todo: optional to fix, before it throws exception
    @Override
    public void setClient(String username, Client client) throws NotFoundException {
        /*User userFromDb = userService.findByUsername(username).orElseThrow(NotFoundException::new);*/
        User userFromDb = userService.findByUsername(username);
        userFromDb.setClient(client);

        userRepository.save(userFromDb);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

/*    public void addUser(User user) {
        userRepository.save(user);
    }*/

    public void addClientInfo(User user, Client client) {
        user.setClient(client);
        userRepository.save(user);
    }

    public void addClientInfo(long id, Client client) {
        User user = userRepository.findById(id);
        user.setClient(client);
        userRepository.save(user);
    }

    public Client getClientByUserId(long id) {
        User user = userRepository.findById(id);
        return user.getClient();
    }

    public User getUserById(long id) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(id));
        return optionalUser.orElseThrow(NotFoundException::new);
    }

    public void deleteClientInfo(long id) {
        User user = userRepository.findById(id);
        user.setClient(null);
        userRepository.save(user);
    }
}
