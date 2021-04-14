package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Circuit;

import java.util.List;
import java.util.Optional;

public interface CircuitService {

    List<Circuit> updateCircuits();

    List<Circuit> getCircuits();

    Optional<Circuit> getCircuit(String id);
}
