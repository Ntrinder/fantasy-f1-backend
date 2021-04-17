package com.idiotproof.fantasy.f1.backend.http;

import com.idiotproof.fantasy.f1.backend.models.*;

import java.util.List;

public interface ErgastHttp {

    List<Driver> getDrivers(boolean asJson);

    List<Constructor> getConstructors(boolean asJson);

    List<Circuit> getCircuits(boolean asJson);

    List<FastestLap> getFastestLaps(boolean asJson);

    List<Race> getRaces(boolean asJson);

    List<Result> getResults(boolean asJson);

}
