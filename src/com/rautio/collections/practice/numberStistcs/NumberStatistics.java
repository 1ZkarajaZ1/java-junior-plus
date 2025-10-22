package com.rautio.collections.practice.numberStistcs;

import java.util.*;


public class NumberStatistics {
    List<Integer> numStatList = new ArrayList<>();

    //  Структуры для статистики (тебе нужно реализовать)
   // private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());

    //private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    private Map<Integer, Integer> frequencyMap = new HashMap<>();
    private Set<Integer> uniqueNumbers = new HashSet<>();
    static NumberStatistics stats = new NumberStatistics();

    public static void main(String[] args) {

        stats.generateData();

        stats.mostFreqNums();

        stats.printData();

    }

    public void addNumber(int number) {
        numStatList.add(number);
        frequencyMap.merge(number, 1, Integer::sum);
        uniqueNumbers.add(number);
    }

    public void generateData() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(100);
            addNumber(number);
        }
    }
        public double getMedian() {
            List<Integer> sorted = new ArrayList<>(numStatList);
            Collections.sort(sorted);
            int middle = sorted.size() / 2;
            if (middle%2==1){
                return sorted.get(middle);
            } else return (sorted.get(middle - 1) + sorted.get(middle + 1)) / 2.0;
     }
    public void mostFreqNums() {
        int max_Frequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > max_Frequency) {
                max_Frequency = frequency;
            }
        }
        System.out.printf("Список мах повтора значений %d%n", max_Frequency);
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue().equals(max_Frequency)) {
                System.out.println(entry.getKey());
            }
        }

    }

    public Set<Integer> getUniqueNum() {

        return new HashSet<>(numStatList);

    }

    public void printData() {
        System.out.printf("Уникальные числа кол-во %d%n", stats.getUniqueNum().size());
        System.out.printf("Всего чисел %d%n ", stats.numStatList.size());
        System.out.print(stats.numStatList);
        frequencyMap.forEach((key, value) -> System.out.println("Значение " + key + " Частота  " + value));
        System.out.printf("Медиана равна %f%n", getMedian());
    }
}
/*
4. Статистика чисел

public class NumberStatistics {
    // Анализировать поток чисел:
    // - Медиана (PriorityQueue)
    // - Мода (самое частое число)
    // - Уникальные числа
}
Отличное задание! NumberStatistics охватывает важные статистические понятия. Вот инструкция:

🎯 Что нужно реализовать:
1. Медиана (Median)
Идея: Число, разделяющее упорядоченную выборку пополам

Инструмент: PriorityQueue - две кучи (min-heap + max-heap)

Ссылки:
PriorityQueue JavaDoc
Медиана через две кучи (визуализация)

2. Мода (Mode)
Идея: Число, встречающееся наиболее часто
Инструмент: HashMap<Integer, Integer> для подсчёта частот
Ссылки:

HashMap для подсчёта частот

3. Уникальные числа
Идея: Все различные числа без дубликатов

Инструмент: HashSet<Integer>

Ссылки:

HashSet JavaDoc

🔧 Ключевые инструменты Java:
Для медианы:
java
PriorityQueue<Integer> maxHeap; // для левой половины (меньшие числа)
PriorityQueue<Integer> minHeap; // для правой половины (большие числа)
Для моды:
java
Map<Integer, Integer> frequencyMap = new HashMap<>();
// Использовать: frequencyMap.merge(number, 1, Integer::sum)
Для уникальных чисел:
java
Set<Integer> uniqueNumbers = new HashSet<>();
📊 Алгоритм для медианы:
Две кучи:
maxHeap (меньшие числа) - Comparator.reverseOrder()
minHeap (большие числа) - естественный порядок
Балансировка:
Поддерживать размеры куч ±1 элемент
Медиана = вершина большей кучи или среднее двух вершин

🚀 Пошаговая инструкция:
1. Создай класс с полями:
Два PriorityQueue для медианы
HashMap для моды
HashSet для уникальных чисел

2. Метод addNumber(int number):
Добавь число в обе кучи (с балансировкой)
Обнови frequencyMap
Добавь в uniqueNumbers

3. Методы-геттеры:
getMedian() - возвращает медиану
getMode() - возвращает моду (учти ничью!)
getUniqueNumbers() - возвращает уникальные числа

💡 Полезные ссылки:
PriorityQueue tutorial - работа с кучами
Медиана на двух кучах - алгоритм
Статистика в Java - обзор подходов

🎯 Сложные моменты:
Балансировка куч для медианы
Обработка ничьи в моде (несколько чисел с одинаковой частотой)
Эффективность при потоковой обработке
Начинай с медианы - это самая интересная часть! Если возникнут трудности - помогу разобраться!
 */
