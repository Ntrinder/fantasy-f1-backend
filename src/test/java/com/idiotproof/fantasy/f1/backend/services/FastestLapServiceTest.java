package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.FastestLap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FastestLapServiceTest {

    @Autowired
    FastestLapService fastestLapService;

    @Test
    public void test_findFastestLaps() {
        List<FastestLap> fastestLaps = fastestLapService.findFastestLaps();
        Assertions.assertNotNull(fastestLaps, "Error Retrieving all the fastest laps");
    }

}
