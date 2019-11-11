package com.lottery.numbers.service.service;

import com.lottery.numbers.service.model.GameNumbers;
import com.lottery.numbers.service.repository.GameNumbersRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@AllArgsConstructor
@Component
public class GenerateNumbersScheduler {

    private GameNumbersRepository gameNumbersRepository;
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void saveGeneratedNumbersToDatabase() {
        int[] generatedNumbers = generateRandomNumbers(5, 40);
        for (int number : generatedNumbers) {
            System.out.println(number);
        }
       gameNumbersRepository.save(new GameNumbers(generatedNumbers, Instant.now()));
    }

    private int[] generateRandomNumbers(int n, int maxRange) {
        assert n <= maxRange : "cannot get more unique numbers than the size of the range";

        int[] result = new int[n];
        Set<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {

            int newRandom;
            do {
                newRandom = random.nextInt(maxRange + 1);
            } while (used.contains(newRandom));
            result[i] = newRandom;
            used.add(newRandom);
        }
        return result;
    }
}