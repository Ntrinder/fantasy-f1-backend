package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.Driver;

public interface DriverMapper {

    static Driver updateDriver(Driver outgoing, Driver incoming) {
        outgoing.setFirstName(incoming.getFirstName());
        outgoing.setLastName(incoming.getLastName());
        outgoing.setDriverCode(incoming.getDriverCode());
        outgoing.setDriverNumber(incoming.getDriverNumber());
        outgoing.setNationality(incoming.getNationality());
        outgoing.setDateOfBirth(incoming.getDateOfBirth());
        return outgoing;
    }

}
