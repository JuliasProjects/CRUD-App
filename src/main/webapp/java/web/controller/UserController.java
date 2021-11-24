package controller;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;



import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public ModelAndView allUsers() {
        List<User> list = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersList");
        modelAndView.addObject("allUsers", list);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(id);
        modelAndView.addObject("user", userService.getUserById(id));
        System.out.println(userService.getUserById(id));
        modelAndView.setViewName("updatePage");
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        userService.updateUser(user);
        return modelAndView;
    }

    @GetMapping("/addPage")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        userService.addUser(user);
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        userService.removeUser(id);
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }
}