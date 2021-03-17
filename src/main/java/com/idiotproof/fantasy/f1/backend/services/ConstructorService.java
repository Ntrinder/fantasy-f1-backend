package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Constructor;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {

    List<Constructor> getConstructors();

    Optional<Constructor> getConstructor(String id);

}
