package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

}
