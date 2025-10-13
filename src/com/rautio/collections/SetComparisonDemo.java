package com.rautio.collections;

import java.util.*;

public class SetComparisonDemo {
    public static void main(String[] args) {

        long startTime;
        long endTime;
        long duration;

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        int count = 100000;


        startTime = System.nanoTime();
        for (int i = 0; i != count; i++) {

            hashSet.add("Andrey" + i);

        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSetFill = " + duration);


        startTime = System.nanoTime();
        for (int i = 0; i != count; i++) {
            linkedHashSet.add("Andrey" + i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSetFill = " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i != count; i++) {
            treeSet.add("Andrey" + i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSetFill = " + duration);

        // Поиск элементов
        startTime = System.nanoTime();
        boolean x = hashSet.contains("7");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSetFind = " + duration + " " + x);

        startTime = System.nanoTime();
        boolean f = linkedHashSet.contains("7");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("linkedHashSetFind = " + duration + " " + f);

        startTime = System.nanoTime();
        boolean z = treeSet.contains("Andrey7!");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSetFind = " + duration + " " + z);
        // удаление элементов
        startTime = System.nanoTime();

        hashSet.remove("Andrey 50000");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashSetRemove = " + duration);

        startTime = System.nanoTime();
        linkedHashSet.remove("Andrey 50000");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("linkedHashSetRemove = " + duration);

        startTime = System.nanoTime();
        treeSet.remove("Andrey 50000");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSetRemove = " + duration);
        // вывод элементов порядок
        System.out.println("Порядок вывода HashSet");
        hashSet.stream().limit(5).forEach(System.out::println);

        System.out.println("Порядок вывода LinkedHashSet");
        linkedHashSet.stream().limit(5).forEach(System.out::println);

        System.out.println("Порядок вывода TreeSet");
        treeSet.stream().limit(5).forEach(System.out::println);
    }

}



/*
Задача:



Что сравнивать:


Порядок элементов при выводе

 */