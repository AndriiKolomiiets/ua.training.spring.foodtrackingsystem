package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.spring.foodtrackingsystem.model.domain.User;

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
userServiceRepo.addUser(user);*//*
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

    /*@GetMapping(value = "/admin")
    public String adminHome() {
        return "admin";
    }*/

  /*  @GetMapping(value = "/user")
    public String userHome() {
        return "user";
    }*/

    @GetMapping(value = "/hello")
    public String hello(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        model.addAttribute("username", user.getUsername());
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        /*BindingResult bindingResult,*/
                        Model model) {
        /*if (error != null && !error.isEmpty()) {
            model.addAttribute("message", "Something goes wrong...");
        }
        if (logout != null && !logout.isEmpty()) {
            model.addAttribute("message", "Something goes wrong...");
        }*/
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping(value = {"/", "/home"})
    public String startPage() {
        return "home";
    }
}
