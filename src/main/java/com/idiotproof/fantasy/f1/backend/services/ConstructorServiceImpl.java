package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.http.ErgastHttp;
import com.idiotproof.fantasy.f1.backend.mappers.ConstructorMapper;
import com.idiotproof.fantasy.f1.backend.models.Constructor;
import com.idiotproof.fantasy.f1.backend.repos.ConstructorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {

    public static Logger LOG = LoggerFactory.getLogger(ConstructorServiceImpl.class);

    @Autowired
    private ErgastHttp api;

    @Autowired
    private ConstructorRepo constructorRepo;

    @Override
    public List<Constructor> updateConstructors() {
        LOG.info("updating constructors from api.");
        List<Constructor> constructors = api.getConstructors(true);
        constructors.forEach(apiConstructor -> {
            Constructor dbConstructor = constructorRepo.findByConstructor(apiConstructor);
            if (dbConstructor != null) {
                ConstructorMapper.updateConstructor(dbConstructor, apiConstructor);
                constructorRepo.save(dbConstructor);
            } else {
                constructorRepo.save(apiConstructor);
            }
        });
        return constructors;
    }

    @Override
    public List<Constructor> getConstructors() {
        LOG.info("Getting all constructors.");
        return constructorRepo.findAll();
    }

    @Override
    public Optional<Constructor> getConstructor(String id) {
        LOG.info("Getting constructors with id: " + id);
        return constructorRepo.findById(Integer.parseInt(id));
    }
}
