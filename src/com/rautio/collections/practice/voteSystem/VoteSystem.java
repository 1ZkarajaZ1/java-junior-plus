package com.rautio.collections.practice.voteSystem;

import java.util.*;
import java.util.stream.Collectors;

public class VoteSystem {
    Scanner scan = new Scanner(System.in);
    int scanInput;

    enum Candidates {
        ИВАНОВ, ПЕТРОВ, СИДОРОВ, ПРОТИВ_ВСЕХ
    }

    HashMap<Candidates, Integer> voteCalc = new HashMap<>();

    public static void main(String[] args) {
        VoteSystem x1 = new VoteSystem();
        x1.startVoting();

    }

    public void startVoting() {

        do {

            System.out.println("Введите номер Кандидата , за которого голосуете 1=ИВАНОВ,2=ПЕТРОВ,3=СИДОРОВ, 4= Против Всех, 0 =прекратить голосование");
            scanInput = scan.nextInt();
            Candidates candidate = null;
            if (scanInput < 0 || scanInput > 4) {
                System.out.println("Неправильное заполнение");
                continue;
            }
            switch (scanInput) {
                case 1 -> candidate = Candidates.ИВАНОВ;
                case 2 -> candidate = Candidates.ПЕТРОВ;
                case 3 -> candidate = Candidates.СИДОРОВ;
                case 4 -> candidate = Candidates.ПРОТИВ_ВСЕХ;
            }
            // Вариант 1: Method reference (более читаемо)
            voteCalc.merge(candidate, 1, Integer::sum);
// Вариант 2: Lambda expression (более явно)
// voteCalc.merge(candidate, 1, (oldValue, newValue) -> oldValue + newValue);
// Вариант 3: Классический подход (без merge)
// voteCalc.put(candidate, voteCalc.getOrDefault(candidate, 0) + 1);
//            Вариант 4: Классический подход (новичковый)(без merge)
//            if (voteCalc.containsKey(candidate)) {
//            voteCalc.put(candidate,  voteCalc.get(candidate) + 1);
//            } else {voteCalc.put(candidate, 1);}
        }
        while (scanInput != 0);
        System.out.println("Голосование окончено");

        Optional<Map.Entry<Candidates, Integer>> winner = voteCalc.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if (winner.isPresent()) {
            List<Map.Entry<Candidates, Integer>> topWinners = voteCalc.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(winner.get().getValue()))
                    .toList();
            if (topWinners.size()>1) {
                System.out.printf("Во второй тур переходят %s%n", topWinners);
            }
            else {
                System.out.printf("Победитель %s%n c результатом %d%n",winner.get().getKey(),winner.get().getValue() );
            }
        }


    }
}

/*
2. Система голосования

public class VotingSystem {
    // Участники голосуют за варианты
    // Подсчитать результаты и вывести победителя
    // Учесть возможность ничьи

 */