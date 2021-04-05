package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResultServiceTest {

    @Autowired
    ResultService raceService;

    @Test
    public void test_findRaces() {
        List<Result> fastestLaps = raceService.findResults();
        Assertions.assertNotNull(fastestLaps, "Error Retrieving all the results.");
    }

}
