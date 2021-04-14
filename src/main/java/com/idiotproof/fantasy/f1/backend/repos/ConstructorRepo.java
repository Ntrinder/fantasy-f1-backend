package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepo extends JpaRepository<Constructor, Integer> {

    Constructor findConstructorByNameAndConstructorIdentifierAndNationality(String name, String identifier, String Nationality);

    default Constructor findByConstructor (Constructor constructor) {
        return findConstructorByNameAndConstructorIdentifierAndNationality(
                constructor.getName(),
                constructor.getConstructorIdentifier(),
                constructor.getNationality());
    }

}
