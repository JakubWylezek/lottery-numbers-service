package com.lottery.numbers.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class GameNumbersDto {

    private int[] numbers;
    private LocalDateTime date;
}
