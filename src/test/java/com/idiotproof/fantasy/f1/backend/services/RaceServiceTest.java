package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RaceServiceTest {

    @Autowired
    RaceService raceService;

    @Test
    public void test_findRaces() {
        List<Race> races = raceService.findRaces();
        Assertions.assertNotNull(races, "Error Retrieving all the races.");
    }

}
