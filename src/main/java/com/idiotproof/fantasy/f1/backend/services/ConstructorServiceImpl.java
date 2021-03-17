package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.repos.ConstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    @Autowired
    private ConstructorRepo constructorRepo;

}
