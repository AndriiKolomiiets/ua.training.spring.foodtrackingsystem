package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import ua.training.spring.foodtrackingsystem.exceptions.NotFoundException;
import ua.training.spring.foodtrackingsystem.model.domain.Client;
import ua.training.spring.foodtrackingsystem.model.domain.DayMeal;
import ua.training.spring.foodtrackingsystem.model.domain.Food;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.services.AddMealService;
import ua.training.spring.foodtrackingsystem.model.services.FindFoodService;
import ua.training.spring.foodtrackingsystem.model.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestWebController {
    @Autowired
//    UserRepository userRepository;
            UserService userService;
    @Autowired
    AddMealService addMealService;
    @Autowired
    FindFoodService findFoodService;

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

    //todo: add Food Service, Food Repository
    @GetMapping(value = "food")
    public Response getFood(/*@PathVariable(required = true) long id*/) {
        List<Food> foodList = findFoodService.getAllFoods();
        return new Response("200", foodList);
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

    @PostMapping(value = "/meal")
    public Response addMeal(@RequestBody DayMeal meal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        try {
            addMealService.addMeal(user.getClient(), meal);
        } catch (NotFoundException|NullPointerException e) {
            return new Response("404", null);
        }
        return new Response("200", meal);
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
