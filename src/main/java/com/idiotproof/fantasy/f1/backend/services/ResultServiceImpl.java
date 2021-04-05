package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Result;
import com.idiotproof.fantasy.f1.backend.repos.ResultRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class ResultServiceImpl implements ResultService {

    public static Logger LOG = LoggerFactory.getLogger(ResultServiceImpl.class);

    @Autowired
    private ResultRepo resultRepo;

    @Override
    public List<Result> findResults() {
        LOG.info("Finding all results.");
        return resultRepo.findAll();
    }

    @Override
    public Optional<Result> findResult(String id) {
        LOG.info("Finding result with id: " + id);
        return resultRepo.findById(Integer.parseInt(id));
    }
}
