package com.lottery.numbers.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameNumbersDto {

    private int[] numbers;
}
