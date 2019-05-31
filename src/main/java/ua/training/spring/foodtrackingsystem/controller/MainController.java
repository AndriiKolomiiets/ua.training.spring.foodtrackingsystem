package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.training.spring.foodtrackingsystem.model.User;
import ua.training.spring.foodtrackingsystem.model.UserServiceRepo;

@Controller
public class MainController {
    @Autowired
    UserServiceRepo userServiceRepo;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String index(User user) {
       /* user.setLogin("login");
        user.setPassword("pass");
userServiceRepo.save(user);*/
        return "login";
    }

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String viewHome() {

        return "home";
    }

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public String viewHello() {
        return "hello";
    }

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String viewPersonList() {

        return "personList";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String viewRegistration() {

        return "registration";
    }


}
