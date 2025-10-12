package com.rautio.collections;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> test = new TreeMap<>();
        test.put("apple", 1);
        test.put("banana", 2);
        test.put("1banana", 3);
        test.put("cherry", 4);
        test.put("orange", 5);
        test.put("1apple", 6);
        test.put("mint", 7);
        test.put("coca", 8);
        test.put("b", 9);
        test.put("na", 10);
        for (Map.Entry<String, Integer> entry : test.entrySet()) {
            System.out.println("Ключ равен " + entry.getKey() + " " + "Value= " + entry.getValue());
        }
    }
}

