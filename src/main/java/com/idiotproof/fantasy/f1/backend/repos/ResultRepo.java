package com.idiotproof.fantasy.f1.backend.repos;

import com.idiotproof.fantasy.f1.backend.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

    Result findByPositionAndStatusAndTime(int position, String status, String time);

    default Result findByResult(Result result) {
        return findByPositionAndStatusAndTime(
                result.getPosition(),
                result.getStatus(),
                result.getTime());
    }

}
