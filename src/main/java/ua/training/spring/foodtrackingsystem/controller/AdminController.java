package ua.training.spring.foodtrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.training.spring.foodtrackingsystem.model.domain.Role;
import ua.training.spring.foodtrackingsystem.model.domain.User;
import ua.training.spring.foodtrackingsystem.model.repositories.UserRepository;

import static java.util.stream.Collectors.joining;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public String userList(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles","user");
//todo: getAuthority
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles", user.getAuthorities().stream().map(Role::getAuthority).collect(joining(",")));*/
        return "admin/userList";
    }

    @GetMapping(value = "/userStat/{id}")
    public String userStat(@PathVariable String pathId ){
        long id = Long.parseLong(pathId);
        userRepository.findById(id);

        return "admin/userStatistic";
    }


}
