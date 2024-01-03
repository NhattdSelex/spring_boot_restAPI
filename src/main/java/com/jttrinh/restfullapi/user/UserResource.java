package com.jttrinh.restfullapi.user;


import com.jttrinh.restfullapi.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        final User userValue = userDAOService.getOne(id);
        if(userValue == null){
            throw  new UserNotFoundException("Hello not found user");
        }

        return userValue ;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createdUser(@RequestBody User user){
        User newUser = userDAOService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable int id){
        userDAOService.remove(id);
    }
}
