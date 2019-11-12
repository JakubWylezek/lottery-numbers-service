package com.lottery.numbers.service.controller;

import com.lottery.numbers.service.dto.GameNumbersDto;
import com.lottery.numbers.service.service.GameNumbersService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GameNumbersController {

    private GameNumbersService gameNumbersService;

    public GameNumbersController(GameNumbersService gameNumbersService) {
        this.gameNumbersService = gameNumbersService;
    }

    @GetMapping("/numbers")
    public ResponseEntity<GameNumbersDto> getLastNumbers() {
        return new ResponseEntity<>(gameNumbersService.getLastNumbers(), HttpStatus.OK);
    }

    //TODO
    @GetMapping("/numbers/find")
    public ResponseEntity<List<GameNumbersDto>> getNumbersByDate(
            @RequestParam(value = "dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime from,
            @RequestParam(value = "dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime to) {
        return new ResponseEntity<>(gameNumbersService.getNumbersByDate(from, to), HttpStatus.OK);
    }
}
