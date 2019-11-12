package com.lottery.numbers.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@Document("game_numbers")
public class GameNumbers {

    @MongoId
    private String id;
    private int[] numbers;
    private LocalDateTime date;

    public GameNumbers(int[] numbers, LocalDateTime date) {
        this.numbers = numbers;
        this.date = date;
    }
}
