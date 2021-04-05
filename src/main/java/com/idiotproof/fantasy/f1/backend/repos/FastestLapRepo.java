package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.FastestLap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FastestLapRepo extends JpaRepository<FastestLap, Integer> {
}
