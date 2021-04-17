package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.Race;

public interface RaceMapper {

    static Race updateRace(Race outgoing, Race incoming) {
        outgoing.setSeason(incoming.getSeason());
        outgoing.setRound(incoming.getRound());
        outgoing.setCircuit(incoming.getCircuit());
        outgoing.setDate(incoming.getDate());
        outgoing.setTime(incoming.getTime());
        outgoing.setResults(incoming.getResults());
        return outgoing;
    }

}
