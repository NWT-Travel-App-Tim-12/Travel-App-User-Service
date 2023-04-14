package com.app.travel.service.user.controller;

import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "")
    public @ResponseBody ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable Integer id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }





}
