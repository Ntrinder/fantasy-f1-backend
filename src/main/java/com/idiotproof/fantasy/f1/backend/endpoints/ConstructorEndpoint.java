package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.models.Constructor;
import com.idiotproof.fantasy.f1.backend.services.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ConstructorEndpoint {

    @Autowired
    ConstructorService constructorService;

    @GetMapping("/constructors")
    public List<Constructor> getConstructors() { return constructorService.getConstructors(); }

    @GetMapping("/constructor/{id}")
    public Optional<Constructor> getConstructor(@PathVariable String id) {
        return constructorService.getConstructor(id);
    }

}
