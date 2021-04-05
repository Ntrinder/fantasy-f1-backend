package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Race;
import com.idiotproof.fantasy.f1.backend.repos.RaceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class RaceServiceImpl implements RaceService {

    public static Logger LOG = LoggerFactory.getLogger(RaceServiceImpl.class);

    @Autowired
    private RaceRepo raceRepo;

    @Override
    public List<Race> findRaces() {
        LOG.info("Finding all races.");
        return raceRepo.findAll();
    }

    @Override
    public Optional<Race> findRace(String id) {
        LOG.info("Finding race with id: " + id);
        return raceRepo.findById(Integer.parseInt(id));
    }
}
