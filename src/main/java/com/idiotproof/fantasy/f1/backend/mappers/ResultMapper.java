package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.Result;

public interface ResultMapper {

    static Result updateRace(Result outgoing, Result incoming) {
        outgoing.setDriver(incoming.getDriver());
        outgoing.setPosition(incoming.getPosition());
        outgoing.setStatus(incoming.getStatus());
        outgoing.setTime(incoming.getTime());
        outgoing.setFastestLap(incoming.getFastestLap());
        return outgoing;
    }

}
