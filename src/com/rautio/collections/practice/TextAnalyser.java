package com.rautio.collections.practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;



public class TextAnalyser {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите текст: ");
//        String text = scanner.nextLine();
//        if (text == null || text.trim().isEmpty()) {
//            System.out.println("Текст не введен!");
//            return;
//        }

        Path path = Paths.get("input.txt");
        String text =null;
        try {
            text = Files.readString(path, Charset.forName("Windows-1251"));
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения файла" + e.getMessage());
            System.exit(1);
        }


        String cleanWord = text.replaceAll("[^a-zA-Zа-яА-Я0-9]", " ").toLowerCase();//Очистка слов от знаков препинания:
        String[] words = cleanWord.trim().split("\\s+");  // Разделитель: пробелы, табы, переносы
        Arrays.sort(words);
        //Set<String> uniqueSortedWords = new TreeSet<>(Arrays.asList(words));
        HashMap<String, Integer> textMapCount = new HashMap<>();
//        List<String> sortedList = Arrays.asList(words);
//        List<String> sortedList1 = new ArrayList<>(Arrays.asList(words));
//        List<String> sortedList2 = Collections.addAll(words)
//        1 способ
//        for (String word:words) {
//            if (textMapCount.containsKey(word)) {
//                textMapCount.put(word, textMapCount.get(word) + 1);
//            }
//                else {textMapCount.put(word, 1);
//            }
//        }
        // 2 способ GetOrDefault
//        for (String word:words) {
//            textMapCount.put(word,textMapCount.getOrDefault(word, 0)+1);
//        }
//        3  способint


        int maxfreq = 0;

        for (String word : words) {
            int newCount = textMapCount.merge(word, 1, Integer::sum);
            if (newCount > maxfreq) {
                maxfreq = newCount;
            }

        }

//        textMapCount.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .ifPresent(maxfreq1 ->
//                        System.out.printf("Максимальное количество повторов= %d у слова %s%n", maxfreq1.getValue(), maxfreq1.getKey()));

        int maxFreq = textMapCount.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        List<String> maxFreqValues = textMapCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFreq)
                .map(Map.Entry::getKey)
                .toList();
        for (String string : maxFreqValues) {
            System.out.printf("Самое частое слово  %s    встречается  %d  раз %n", string, maxFreq);
        }
        System.out.println( "количество уникальных слов " + textMapCount.size()) ;

for (String word: words) {
    System.out.println(word);
}
    }
}

/*
📝 Задание: Практическое применение коллекций
Цель:
Реализовать полезную утилиту, используя полученные знания о коллекциях

Варианты на выбор:
1. Анализатор текста

public class TextAnalyzer {
    // Проанализировать текст и вывести:
    // - Количество уникальных слов
    // - Самое частое слово
    // - Все слова в алфавитном порядке
}


✅ Правильный подход:
Вариант 1: Чтение с Scanner


Вариант 2: Разбиение на слова


⚠️ Важные моменты:
Обработай пустой ввод

Учти регистр букв (привести к нижнему/верхнему)

Отфильтруй пустые строки после очистки

Начинай! Если возникнут сложности с регулярками или обработкой слов - помогу! 🚀
🎯 Рекомендую: Анализатор текста
Он охватит:
Map для подсчёта частот слов
Set для уникальных слов
List для сортировки
Queue для обработки потока слов

 */