package com.lottery.numbers.service.controller;

import com.lottery.numbers.service.service.GameNumbersService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GameNumbersController {

    private GameNumbersService gameNumbersService;

    public GameNumbersController(GameNumbersService gameNumbersService) {
        this.gameNumbersService = gameNumbersService;
    }

    @GetMapping("/numbers")
    public ResponseEntity<Object> getLastNumbersOrByDate(
            @RequestParam(value = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dateFrom,
            @RequestParam(value = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime dateTo,
            Pageable pageable) {

        return (dateFrom == null) ?
                new ResponseEntity<>(gameNumbersService.getLastNumbers(), HttpStatus.OK) :
                new ResponseEntity<>(gameNumbersService.getNumbersByDate(dateFrom, dateTo, pageable), HttpStatus.OK);

    }
}
