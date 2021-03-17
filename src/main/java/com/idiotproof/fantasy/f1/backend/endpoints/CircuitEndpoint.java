package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.services.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CircuitEndpoint {

    @Autowired
    CircuitService circuitService;

    @GetMapping("/circuits")
    public List<Circuit> getCircuits() { return circuitService.getCircuits(); }

    @GetMapping("/circuit/{id}")
    public Optional<Circuit> getCircuit(@PathVariable String id) {
        return circuitService.getCircuit(id);
    }

}
