package com.rautio.collections.practice.cashSystem;

import java.util.Map;

public class CacheSystem {
    public static void main(String[] args) {
        SimpleCache<String, Integer> testCache = new SimpleCache<>(2);
        testCache.put("A", 1);
        testCache.put("B", 2);
        testCache.get("A");     // A становится "моложе"
        testCache.put("C", 3);  // B должен удалиться (он самый старый)
//        testCache.cache.forEach((key, value) -> {
//            System.out.println(key + " " + value);
//        });
//        for (Map.Entry<String ,Integer> entry : testCache.cache.entrySet()) {
//            System.out.println(entry.getKey()+ " " + entry.getValue());
//        }
        testCache.cache.entrySet().stream()
                .map(entry->entry.getKey() + entry.getValue() )
                .forEach(System.out::println);
    }
}
/*
3. Кэширующая система

public class SimpleCache<K, V> {
    // Реализовать LRU-кэш (вытеснение давно неиспользуемых)
    // Использовать LinkedHashMap с accessOrder=true
}

🔧 Что нужно сделать:
*/
