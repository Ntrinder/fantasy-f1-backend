package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.repos.CircuitRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService {

    public static Logger LOG = LoggerFactory.getLogger(CircuitServiceImpl.class);

    @Autowired
    private CircuitRepo circuitRepo;

    @Override
    public List<Circuit> getCircuits() {
        LOG.info("Getting all circuits.");
        return circuitRepo.findAll();
    }

    @Override
    public Optional<Circuit> getCircuit(String id) {
        LOG.info("Getting circuit with id: " + id);
        return circuitRepo.findById(Integer.parseInt(id));
    }
}
