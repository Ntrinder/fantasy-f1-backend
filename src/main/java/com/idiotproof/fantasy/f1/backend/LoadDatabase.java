package com.idiotproof.fantasy.f1.backend;

import com.idiotproof.fantasy.f1.backend.repos.FastestLapRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FastestLapRepo fastestLapRepo) {
        return null;
    }

}
