package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepo extends JpaRepository<Race, Integer> {

    Race findBySeasonAndRoundAndDateAndTime(int season, int round, String date, String time);

    default Race findByRace(Race race) {
        return findBySeasonAndRoundAndDateAndTime(
                race.getSeason(),
                race.getRound(),
                race.getDate(),
                race.getTime());
    }
}
