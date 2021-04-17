package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.http.ErgastHttp;
import com.idiotproof.fantasy.f1.backend.mappers.DriverMapper;
import com.idiotproof.fantasy.f1.backend.mappers.FastestLapMapper;
import com.idiotproof.fantasy.f1.backend.models.Driver;
import com.idiotproof.fantasy.f1.backend.models.FastestLap;
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
    private ErgastHttp api;

    @Autowired
    private FastestLapRepo fastestLapRepo;

    @Override
    public List<FastestLap> updateFastestLaps() {
        LOG.info("updating fastest laps from api.");
        List<FastestLap> fastestLaps = api.getFastestLaps(true);
        fastestLaps.forEach(apiFastestLap -> {
            FastestLap dbFastestLap = fastestLapRepo.findByFastestLap(apiFastestLap);
            if (dbFastestLap != null) {
                FastestLapMapper.updateFastestLap(dbFastestLap, apiFastestLap);
                fastestLapRepo.save(dbFastestLap);
            } else {
                fastestLapRepo.save(apiFastestLap);
            }
        });
        return fastestLaps;
    }

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
