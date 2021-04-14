package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Driver;
import com.idiotproof.fantasy.f1.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {

    boolean existsByFirstNameAndLastNameAndDriverNumberAndDriverCodeAndDateOfBirthAndNationality(String firstName, String lastName, int driverNumber, String driverCode, String dateOfBirth, String nationality);

    default boolean existsByDriver(Driver driver) {
        return existsByFirstNameAndLastNameAndDriverNumberAndDriverCodeAndDateOfBirthAndNationality(
                driver.getFirstName(),
                driver.getLastName(),
                driver.getDriverNumber(),
                driver.getDriverCode(),
                driver.getDateOfBirth(),
                driver.getNationality()
        );
    }

    Driver findByFirstNameAndLastNameAndDriverNumberAndDriverCodeAndDateOfBirthAndNationality(String firstName, String lastName, int driverNumber, String driverCode, String dateOfBirth, String nationality);

    default Driver findByDriver(Driver driver) {
        return findByFirstNameAndLastNameAndDriverNumberAndDriverCodeAndDateOfBirthAndNationality(
                driver.getFirstName(),
                driver.getLastName(),
                driver.getDriverNumber(),
                driver.getDriverCode(),
                driver.getDateOfBirth(),
                driver.getNationality());
    }

}
