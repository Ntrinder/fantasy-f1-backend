package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.User;
import com.idiotproof.fantasy.f1.backend.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        LOG.info("Getting all users.");
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        LOG.info("Getting user with id: " + id);
        return userRepo.findById(Integer.parseInt(id));
    }

    @Override
    public User addUser(User requestUser) {
        LOG.info("Adding user: " + requestUser);
        return userRepo.save(requestUser);
    }

    @Override
    public void deleteUserById(String id) {
        LOG.info("Deleting user with id: " + id);
        userRepo.deleteById(Integer.parseInt(id));
    }

    @Override
    public void deleteUser(User requestUser) {
        LOG.info("Deleting user: " + requestUser);
        userRepo.delete(requestUser);
    }
}
