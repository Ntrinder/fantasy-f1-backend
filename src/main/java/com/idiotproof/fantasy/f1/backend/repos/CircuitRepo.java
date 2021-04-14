package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Circuit;
import com.idiotproof.fantasy.f1.backend.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepo extends JpaRepository<Circuit, Integer> {

    Circuit findCircuitByNameAndCircuitIdentifierAndCountryAndLatitudeAndLongitudeAndLocality(String name, String identifier, String country, Double latitude, Double longitude, String locality);

    default Circuit findByCircuit(Circuit circuit) {
        return findCircuitByNameAndCircuitIdentifierAndCountryAndLatitudeAndLongitudeAndLocality(
                circuit.getName(),
                circuit.getCircuitIdentifier(),
                circuit.getCountry(),
                circuit.getLatitude(),
                circuit.getLongitude(),
                circuit.getLocality());
    }

}
