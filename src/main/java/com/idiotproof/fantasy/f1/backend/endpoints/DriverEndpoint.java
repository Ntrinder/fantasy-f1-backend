package com.idiotproof.fantasy.f1.backend.endpoints;

import com.idiotproof.fantasy.f1.backend.models.Driver;
import com.idiotproof.fantasy.f1.backend.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DriverEndpoint {

    @Autowired
    DriverService driverService;

    @PostMapping("/update-drivers")
    public List<Driver> updateDrivers() {
        return driverService.updateDrivers();
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @GetMapping("/driver/{id}")
    public Optional<Driver> getDriver(@PathVariable String id) {
        return driverService.getDriver(id);
    }

}
