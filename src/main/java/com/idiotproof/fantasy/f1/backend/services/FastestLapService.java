package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.FastestLap;

import java.util.List;
import java.util.Optional;

public interface FastestLapService {

    List<FastestLap> findFastestLaps();

    Optional<FastestLap> findFastestLap(String id);
}
