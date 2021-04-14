package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.http.ErgastHttp;
import com.idiotproof.fantasy.f1.backend.mappers.DriverMapper;
import com.idiotproof.fantasy.f1.backend.models.Driver;
import com.idiotproof.fantasy.f1.backend.repos.DriverRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    public static Logger LOG = LoggerFactory.getLogger(DriverServiceImpl.class);

    @Autowired
    private ErgastHttp api;

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public List<Driver> updateDrivers() {
        LOG.info("updating drivers from api.");
        List<Driver> drivers = api.getDrivers(true);
        drivers.forEach(apiDriver -> {
            Driver dbDriver = driverRepo.findByDriver(apiDriver);
            if (dbDriver != null) {
                DriverMapper.updateDriver(dbDriver, apiDriver);
                driverRepo.save(dbDriver);
            } else {
                driverRepo.save(apiDriver);
            }
        });
        return drivers;
    }

    @Override
    public List<Driver> getDrivers() {
        LOG.info("Getting all drivers.");
        return driverRepo.findAll();
    }

    @Override
    public Optional<Driver> getDriver(String id) {
        LOG.info("Getting driver with id: " + id);
        return driverRepo.findById(Integer.parseInt(id));
    }
}
