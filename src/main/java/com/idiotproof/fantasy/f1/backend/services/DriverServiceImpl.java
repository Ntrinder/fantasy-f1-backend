package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

}
