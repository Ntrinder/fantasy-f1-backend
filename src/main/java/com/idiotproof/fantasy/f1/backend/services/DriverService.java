package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> updateDrivers();

    List<Driver> getDrivers();

    Optional<Driver> getDriver(String id);

}
