package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.services.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircuitEndpoint {

    @Autowired
    CircuitService circuitService;

    @GetMapping("/circuits")
    public List<Circuit> getCircuit() { return circuitService.getCircuits(); }

}
