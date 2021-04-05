package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    List<Race> findRaces();

    Optional<Race> findRace(String id);
}
