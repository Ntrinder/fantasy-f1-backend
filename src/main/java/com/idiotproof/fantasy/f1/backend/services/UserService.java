package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUser(String id);

    User addUser(User requestUser);

    void deleteUserById(String id);

    void deleteUser(User requestUser);

}
