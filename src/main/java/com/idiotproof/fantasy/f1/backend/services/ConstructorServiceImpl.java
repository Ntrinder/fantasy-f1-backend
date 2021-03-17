package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Constructor;
import com.idiotproof.fantasy.f1.backend.repos.ConstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    @Autowired
    private ConstructorRepo constructorRepo;

    @Override
    public List<Constructor> getConstructors() {
        return constructorRepo.findAll();
    }

    @Override
    public Optional<Constructor> getConstructor(String id) {
        return constructorRepo.findById(Integer.parseInt(id));
    }
}
