package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.models.User;
import com.idiotproof.fantasy.f1.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {

    @Autowired
    UserService userService;

    // TODO: testing remove later - this is probably detrimental without access control
    @GetMapping("/users")
    public List<User> getUsers() { return userService.getUsers(); }

}
