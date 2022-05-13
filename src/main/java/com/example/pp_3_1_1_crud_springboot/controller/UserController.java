package com.example.pp_3_1_1_crud_springboot.controller;

import com.example.pp_3_1_1_crud_springboot.model.User;
import com.example.pp_3_1_1_crud_springboot.repository.UserRepository;
import com.example.pp_3_1_1_crud_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService (UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getAllUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser (@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create (@ModelAttribute ("user") User user) {
        userService.addUser (user);
        return "redirect:/users";
    }

    @GetMapping ("/edit/{id}")
    public String edit (Model model, @PathVariable ("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping ("{id}")
    public String update (@ModelAttribute ("user") User user, @PathVariable("id") int id){
        userService.updateUser (id);
        return "redirect:/users";
    }

    @DeleteMapping("delete/{id}")
    public String delete (@PathVariable ("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserByIndex (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/show";
    }
}



