package com.rautio.collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueComparisonDemo {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long duration;
        Queue<String> linkedListQueue = new LinkedList<>();
        Queue<String> priorityQueue = new PriorityQueue<>();
        Queue<String> priorityQueue1 = new PriorityQueue<>();
        Queue<String> linkedListQueue1 = new LinkedList<>();
        Queue<String> arrayDeque = new ArrayDeque<>();
        Queue<String> arrayDeque1 = new ArrayDeque<>();
//добавление элемента в add
        startTime = System.nanoTime();
        linkedListQueue.add("First");
        linkedListQueue.add("Second");
        linkedListQueue.add("Third");
        linkedListQueue.add("Fourth");
        linkedListQueue.add("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration queue (add) = " + duration);
//добавление элемента в offer
        startTime = System.nanoTime();
        linkedListQueue1.offer("First");
        linkedListQueue1.offer("Second");
        linkedListQueue1.offer("Third");
        linkedListQueue1.offer("Fourth");
        linkedListQueue1.offer("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration queue (offer) = " + duration);

        //добавление элемента в add priorityQueue
        startTime = System.nanoTime();
        priorityQueue.add("First");
        priorityQueue.add("Second");
        priorityQueue.add("Third");
        priorityQueue.add("Fourth");
        priorityQueue.add("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration priorityQueue (add) = " + duration);
//добавление элемента в offer
        startTime = System.nanoTime();
        priorityQueue1.offer("First");
        priorityQueue1.offer("Second");
        priorityQueue1.offer("Third");
        priorityQueue1.offer("Fourth");
        priorityQueue1.offer("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration priorityQueue (offer) = " + duration);
//добавление элемента в add ArrayQueue
        startTime = System.nanoTime();
        arrayDeque.add("First");
        arrayDeque.add("Second");
        arrayDeque.add("Third");
        arrayDeque.add("Fourth");
        arrayDeque.add("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration arrayDeque (add) = " + duration);
//добавление элемента в offer ArrayQueue
        startTime = System.nanoTime();
        arrayDeque1.offer("First");
        arrayDeque1.offer("Second");
        arrayDeque1.offer("Third");
        arrayDeque1.offer("Fourth");
        arrayDeque1.offer("Fifth");

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration arrayDeque (offer) = " + duration);
//просмотрр первого элемента  (peek)
        startTime = System.nanoTime();
        linkedListQueue1.peek();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration linkedListQueue1 (peek) = " + duration);

        startTime = System.nanoTime();
        priorityQueue1.peek();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration priorityQueue (peek) = " + duration);

        startTime = System.nanoTime();
        arrayDeque.peek();

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration arrayDeque (peek) = " + duration);

        // Извлечение из начала

        startTime = System.nanoTime();
        linkedListQueue1.remove();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration linkedListQueue1 (remove) = " + duration);

        startTime = System.nanoTime();
        priorityQueue1.remove();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration priorityQueue (remove) = " + duration);

        startTime = System.nanoTime();
        arrayDeque1.remove();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration arrayDeque (remove) = " + duration);

        // Извлечение из начала (poll)
        startTime = System.nanoTime();
        linkedListQueue.poll();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration linkedListQueue1 (poll) = " + duration);

        startTime = System.nanoTime();
        priorityQueue.poll();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration priorityQueue (poll) = " + duration);

        startTime = System.nanoTime();
        arrayDeque.poll();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration arrayDeque (poll) = " + duration);
    }
}

/*

Что сравнивать:
Извлечение из начала (poll()/remove())
Порядок обработки элементов
Тестовый сценарий:
Добавь 10 элементов в каждую очередь
Покажи порядок элементов
Произведи извлечение всех элементов
Замерь время операций
Пример элементов:
java
["Task1", "Task2", "Task3", "HighPriority", "LowPriority"]
Выходные данные:
Выведи:
Время операций
Порядок извлечения элементов из каждой очереди
Размеры очередей до/после операций
        */