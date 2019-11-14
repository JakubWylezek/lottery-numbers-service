package com.lottery.numbers.service.repository;

import com.lottery.numbers.service.model.GameNumbers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface GameNumbersRepository extends MongoRepository<GameNumbers, String> {
    Optional<GameNumbers> findFirstByOrderByDateDesc();

    Page<GameNumbers> getByDateBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);
}
