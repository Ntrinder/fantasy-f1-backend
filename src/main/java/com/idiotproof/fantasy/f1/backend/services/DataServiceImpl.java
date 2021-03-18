package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.http.ErgastHttp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    public static Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    ErgastHttp http;

    @Override
    public String updateDrivers() {
        LOG.info("updating drivers from api.");
        // connect to api
        // get list of drivers in json
        // convert that to a list of drivers
        // update the drivers table with the list of drivers from the api response
        return http.getDriverData(true);
    }
}
