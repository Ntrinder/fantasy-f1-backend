package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.models.Constructor;
import com.idiotproof.fantasy.f1.backend.models.Driver;

import java.util.List;

public interface DataService {

    public List<Driver> updateDrivers();

    public List<Constructor> updateConstructors();

    public List<Circuit> updateCircuits();
}
