package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


   /* @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, User user) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
       *//* user.setLogin("login");
        user.setPassword("pass");
userServiceRepo.save(user);*//*
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
*/

    @GetMapping(value = "/admin")
    public String adminHome() {
        return "admin";
    }

    @GetMapping(value = "/user")
    public String userHome() {
        return "user";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/", "/home"})
    public String startPage() {
        return "home";
    }
}
