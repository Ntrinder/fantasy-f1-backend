package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.models.FastestLap;
import com.idiotproof.fantasy.f1.backend.repos.CircuitRepo;
import com.idiotproof.fantasy.f1.backend.repos.FastestLapRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class FastestLapServiceImpl implements FastestLapService {

    public static Logger LOG = LoggerFactory.getLogger(FastestLapServiceImpl.class);

    @Autowired
    private FastestLapRepo fastestLapRepo;

    @Override
    public List<FastestLap> findFastestLaps() {
        LOG.info("Getting all fastest laps.");
        return fastestLapRepo.findAll();
    }

    @Override
    public Optional<FastestLap> findFastestLap(String id) {
        LOG.info("Getting circuit with id: " + id);
        return fastestLapRepo.findById(Integer.parseInt(id));
    }
}
