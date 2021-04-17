package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.FastestLap;

public interface FastestLapMapper {

    static FastestLap updateFastestLap(FastestLap outgoing, FastestLap incoming) {
        outgoing.setLapNo(incoming.getLapNo());
        outgoing.setRank(incoming.getRank());
        outgoing.setTime(incoming.getTime());
        outgoing.setAvgSpeed(incoming.getAvgSpeed());
        return outgoing;
    }

}
