package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import ua.training.spring.foodtrackingsystem.exceptions.NotFoundException;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestWebController {
    @Autowired
//    UserRepository userRepository;
            UserService userService;

    @GetMapping(value = "/user/all")
    public Response getAllUsers() {
        List<User> users = userService.findAll();
        return new Response("200", users);
    }

    @GetMapping(value = "user/{id}")
    public Response getUserById(@PathVariable(required = true) long id) {
        User user = userService.findById(id);
        return new Response("200", user);
    }

    @PostMapping(value = "user/client/{userId}")
    public String addClientInfo(@RequestBody Client client, @PathVariable long userId) {

        try {
            userService.addClientInfo(userId, client);
        } catch (NotFoundException e) {
            return "404";
        }
        return "200";
    }

    @PostMapping(value = "/user")
    public Response addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (NotFoundException|NullPointerException e) {
            return new Response("404", null);
        }
        return new Response("200", user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping(value = "/user/client/{id}")
    public void deleteClient(@PathVariable long id) {
        userService.deleteClientInfo(id);
    }
}
