package com.lottery.numbers.service.service;

import com.lottery.numbers.service.dto.GameNumbersDto;
import com.lottery.numbers.service.exceptions.custom.NotFoundEntityException;
import com.lottery.numbers.service.model.GameNumbers;
import com.lottery.numbers.service.repository.GameNumbersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameNumbersService {

    private GameNumbersRepository gameNumbersRepository;

    public GameNumbersService(GameNumbersRepository gameNumbersRepository) {
        this.gameNumbersRepository = gameNumbersRepository;
    }

    public GameNumbersDto getLastNumbers() {
        return convertToGameNumbersDto(gameNumbersRepository.findFirstByOrderByDateDesc()
                .orElseThrow(() -> new NotFoundEntityException(GameNumbers.class)));
    }

    public List<GameNumbersDto> getNumbersByDate(LocalDateTime from, LocalDateTime to) {
        return gameNumbersRepository.getByDateBetween(from, to).stream().map(this::convertToGameNumbersDto)
                .collect(Collectors.toList());
    }

    private GameNumbersDto convertToGameNumbersDto(GameNumbers gameNumbers) {
        return GameNumbersDto.builder()
                .numbers(gameNumbers.getNumbers())
                .build();
    }
}
