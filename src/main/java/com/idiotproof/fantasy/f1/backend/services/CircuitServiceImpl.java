package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.repos.CircuitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitServiceImpl implements CircuitService {

    @Autowired
    private CircuitRepo circuitRepo;

    @Override
    public List<Circuit> getCircuits() {
        return circuitRepo.findAll();
    }
}
