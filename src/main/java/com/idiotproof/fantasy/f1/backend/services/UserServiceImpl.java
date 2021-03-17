package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.User;
import com.idiotproof.fantasy.f1.backend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepo.findById(Integer.parseInt(id));
    }

    @Override
    public User addUser(User requestUser) {
        return userRepo.save(requestUser);
    }

    @Override
    public void deleteUserById(String id) {
        userRepo.deleteById(Integer.parseInt(id));
    }

    @Override
    public void deleteUser(User requestUser) {
        userRepo.delete(requestUser);
    }
}
