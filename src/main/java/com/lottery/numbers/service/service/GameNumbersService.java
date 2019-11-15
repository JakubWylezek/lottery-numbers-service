package com.lottery.numbers.service.service;

import com.lottery.numbers.service.dto.GameNumbersDto;
import com.lottery.numbers.service.exceptions.custom.NotFoundEntityException;
import com.lottery.numbers.service.model.GameNumbers;
import com.lottery.numbers.service.repository.GameNumbersRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GameNumbersService {

    private GameNumbersRepository gameNumbersRepository;

    public GameNumbersService(GameNumbersRepository gameNumbersRepository) {
        this.gameNumbersRepository = gameNumbersRepository;
    }

    @Cacheable("numbers")
    public GameNumbersDto getLastNumbers() {
        return convertToGameNumbersDto(gameNumbersRepository.findFirstByOrderByDateDesc()
                .orElseThrow(() -> new NotFoundEntityException(GameNumbers.class)));
    }

    @Cacheable("numbers")
    public Page<GameNumbers> getNumbersByDate(LocalDateTime from, LocalDateTime to, Pageable pageable) {
        return gameNumbersRepository.getByDateBetween(from, to, pageable);    }

    private GameNumbersDto convertToGameNumbersDto(GameNumbers gameNumbers) {
        return GameNumbersDto.builder()
                .numbers(gameNumbers.getNumbers())
                .date(gameNumbers.getDate())
                .build();
    }
}
