package com.idiotproof.fantasy.f1.backend.http;

import com.idiotproof.fantasy.f1.backend.models.Driver;

import java.util.List;

public interface ErgastHttp {

    public List<Driver> getDrivers(boolean asJson);

}
