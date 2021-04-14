package com.idiotproof.fantasy.f1.backend.mappers;

import com.idiotproof.fantasy.f1.backend.models.Constructor;

public interface ConstructorMapper {

    static Constructor updateConstructor(Constructor outgoing, Constructor incoming) {
        outgoing.setName(incoming.getName());
        outgoing.setConstructorIdentifier(incoming.getConstructorIdentifier());
        outgoing.setNationality(incoming.getNationality());
        return outgoing;
    }

}
