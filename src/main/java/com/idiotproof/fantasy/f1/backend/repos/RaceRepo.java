package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepo extends JpaRepository<Race, Integer> {
}
