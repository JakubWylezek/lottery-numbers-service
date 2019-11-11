package com.lottery.numbers.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@Document("game_numbers")
public class GameNumbers {

    @MongoId
    private String id;
    private int[] numbers;
    private Instant date;

    public GameNumbers(int[] numbers, Instant date) {
        this.numbers = numbers;
        this.date = date;
    }
}
