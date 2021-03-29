package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.http.ErgastHttp;
import com.idiotproof.fantasy.f1.backend.models.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    public static Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    ErgastHttp http;

    @Override
    public List<Driver> updateDrivers() {
        LOG.info("updating drivers from api.");
        return http.getDrivers(true);
    }
}
