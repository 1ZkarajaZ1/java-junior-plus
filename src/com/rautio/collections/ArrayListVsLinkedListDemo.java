package com.rautio.collections;


import java.util.*;

public class ArrayListVsLinkedListDemo {
    public static void main(String[] args) {

        Random rnd = new Random();
        long startTime;
        long endTime;
        long duration;

        String[] arrString = new String[100000];
        Integer[] arrInteger = new Integer[100000];
        List<String> listString = new ArrayList<>(100000);
        LinkedList<Integer> linkedlistInteger = new LinkedList<>();


        Arrays.fill(arrString, "5");
        Arrays.setAll(arrInteger, i -> rnd.nextInt(1000));

        listString.addAll(Arrays.asList(arrString));
        Collections.addAll(linkedlistInteger, arrInteger);
       // добавление элемента в конец  LinkedList 860 List 402600
        startTime = System.nanoTime();
        listString.add("Andre");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListAddEnd = " + duration);

        startTime = System.nanoTime();
        linkedlistInteger.add(555);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListAddEnd = " + duration);
        //добавление элемента в начало LinkedList 8400 List 124400
        startTime = System.nanoTime();
        listString.addFirst("Andrey");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListAddFirst = " + duration);

        startTime = System.nanoTime();
        linkedlistInteger.addFirst(5555);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListAddFirst = " + duration);
        //добавление элемента в середину LinkedList 397100 List 24300
        startTime = System.nanoTime();
        listString.add(50001,"Andrey");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListAddMid = " + duration);

        startTime = System.nanoTime();
        linkedlistInteger.add(50001,5555);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListAddMid = " + duration);
        //Доступ к элементам по индексу (GetFirst) LinkedList 3700 List 2600
        startTime = System.nanoTime();
        linkedlistInteger.getFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListGetFirst = " + duration);

        startTime = System.nanoTime();
        listString.getFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListGetFirst = " + duration);

        //Доступ к элементам по индексу (GetLast) LinkedList 2800 List 2800
        startTime = System.nanoTime();
        linkedlistInteger.getLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListGetLast = " + duration);

        startTime = System.nanoTime();
        listString.getLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListGetLast = " + duration);
        //Доступ к элементам по индексу (GetMid) LinkedList 311000 List 4000
        startTime = System.nanoTime();
        linkedlistInteger.get(50000);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListGetMid = " + duration);

        startTime = System.nanoTime();
        listString.get(50000);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListGetMid = " + duration);
        //удаление элемента  начало LinkedList 17900 List 220300
        startTime = System.nanoTime();
        linkedlistInteger.removeFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListRemoveFirst = " + duration);

        startTime = System.nanoTime();
        listString.removeFirst();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListRemoveFirst = " + duration);

        //удаление элемента  конец LinkedList 3500 List 2900
        startTime = System.nanoTime();
        linkedlistInteger.removeLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListRemoveLast = " + duration);

        startTime = System.nanoTime();
        listString.removeLast();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListRemoveLast = " + duration);

        //удаление элемента  cередина LinkedList 176100 List 27600
        startTime = System.nanoTime();
        linkedlistInteger.remove(50000);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration LinkedListRemoveMid = " + duration);

        startTime = System.nanoTime();
        listString.remove(50000);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration ListRemoveMid = " + duration);
    }
}
/*
Требования:




Удаление элементов из начала списка
Удаление элементов из середины списка
Удаление элементов из конца списка
3. Для каждой операции:
Замерь время выполнения для ArrayList
Замерь время выполнения для LinkedList
Выведи результаты в наглядном виде
4. Количество элементов для теста: 100 000
Метод замера времени:
java
long startTime = System.nanoTime();
// выполнение операции
long endTime = System.nanoTime();
long duration = endTime - startTime;
Выходные данные:
Выведи таблицу сравнения, например:

text
Операция: Добавление в начало
ArrayList: 1250 ms
LinkedList: 45 ms
 */