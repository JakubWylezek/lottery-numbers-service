package com.lottery.numbers.service.repository;

import com.lottery.numbers.service.model.GameNumbers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GameNumbersRepository extends MongoRepository<GameNumbers, String> {
    Optional<GameNumbers> findFirstByOrderByDateDesc();

    List<GameNumbers> getByDateBetween(LocalDateTime from, LocalDateTime to);
}
