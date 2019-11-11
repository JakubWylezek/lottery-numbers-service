package com.lottery.numbers.service.repository;

import com.lottery.numbers.service.model.GameNumbers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameNumbersRepository extends MongoRepository<GameNumbers, String> {
}
