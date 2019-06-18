package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.spring.foodtrackingsystem.model.domain.User;

@Controller
public class MainController {

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

   /* @GetMapping(value = "/register")
    public String register(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "registration";
    }*/

    @GetMapping(value = {"/", "/home"})
    public String startPage() {
        return "main";
    }


    @GetMapping(value = {"/error"})
    public String errorPage() {
        return "error";
    }
}

