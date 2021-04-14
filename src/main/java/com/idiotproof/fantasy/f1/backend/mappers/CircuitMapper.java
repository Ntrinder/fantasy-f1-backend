package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.Circuit;

public interface CircuitMapper {

    static Circuit updateCircuit(Circuit outgoing, Circuit incoming) {
        outgoing.setCircuitIdentifier(incoming.getCircuitIdentifier());
        outgoing.setName(incoming.getName());
        outgoing.setCountry(incoming.getCountry());
        outgoing.setLatitude(incoming.getLatitude());
        outgoing.setLongitude(incoming.getLongitude());
        outgoing.setLocality(incoming.getLocality());
        return outgoing;
    }

}
