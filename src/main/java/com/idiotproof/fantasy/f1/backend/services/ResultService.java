package com.idiotproof.fantasy.f1.backend.services;

import com.idiotproof.fantasy.f1.backend.models.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {

    List<Result> findResults();

    Optional<Result> findResult(String id);
}
