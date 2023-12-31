package com.jttrinh.restfullapi.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private UserDAOService userDAOService;

    public UserResource(UserDAOService userDAOService){
        this.userDAOService = userDAOService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDAOService.finalAll();
    }

    @GetMapping(path = "users/{id}")
    public  User getUserById(@PathVariable int id){
        return userDAOService.getOne(id);
    }
}
