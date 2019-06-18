package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.spring.foodtrackingsystem.model.domain.Role;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.services.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, @RequestParam(value = "error", required = false) String error, Model model) {
        User userFromDb = userService.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
/*        user.setAccountStatus(true);
        user.setRoles(Collections.singleton(Role.USER));
userRepo*/
        if (user.getPassword() != null && !user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("passwordError", "Passwords are different!");
        }



        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registration";
        }

        model.addAttribute("error", error != null);
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exist!");
            return "registration";
        }
        return "redirect:/user/foodTracking";
    }
}
