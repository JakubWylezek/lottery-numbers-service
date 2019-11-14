package com.lottery.numbers.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class LotteryNumbersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryNumbersServiceApplication.class, args);
    }

}
