package com.lottery.numbers.service.service;

import com.lottery.numbers.service.repository.GameNumbersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameNumbersService {

    private GameNumbersRepository gameNumbersRepository;
}
