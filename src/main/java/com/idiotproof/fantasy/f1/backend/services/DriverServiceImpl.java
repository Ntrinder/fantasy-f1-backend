package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Driver;
import com.idiotproof.fantasy.f1.backend.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public List<Driver> getDrivers() {
        return driverRepo.findAll();
    }

    @Override
    public Optional<Driver> getDriver(String id) {
        return driverRepo.findById(Integer.parseInt(id));
    }
}
