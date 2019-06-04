package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

import static java.util.stream.Collectors.joining;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping/*(value = "/userlist")*/
    public String mealTracking(Model model) {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles","user");*/

        return "user/mealTracking";
    }

    @GetMapping(value = "/settings")
    public String userSettings(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

//todo: add Client, all user info included in that table
        model.addAttribute("user", user);
        return "user/userSettings";
    }

    @GetMapping(value = "/statistic")
    public String userStatistic(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

//todo: add Meal, get meal by user id
        model.addAttribute("meal", user);
        return "user/mealStatistic";
    }
}
