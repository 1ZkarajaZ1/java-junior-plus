package com.rautio.collections.practice.cashSystem;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> {
    public final LinkedHashMap<K, V> cache;
    private final int capacity;

    public SimpleCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > SimpleCache.this.capacity;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }
}

/*
1. Использовать LinkedHashMap с accessOrder=true


                // TODO: вернуть true когда нужно удалить старейший элемент
            }
        };
    }
}


🎪 Как работает LRU в LinkedHashMap:
accessOrder = true
        false - порядок вставки (insertion-order)

true - порядок доступа (access-order) - нужен нам!

Пример поведения:
java
cache.put("A", 1);  // Кэш: [A=1]
cache.put("B", 2);  // Кэш: [A=1, B=2]
cache.get("A");     // Кэш: [B=2, A=1]  ← A стал "моложе"
cache.put("C", 3);  // Кэш: [B=2, A=1, C=3]
// Если capacity=2, то B удалится как самый старый
📝 Пошаговая инструкция:
Шаг 1: Конструктор с capacity
Создай LinkedHashMap с initialCapacity, loadFactor, accessOrder=true

Переопредели removeEldestEntry

Шаг 2: Методы get() и put()
Просто делегируй их LinkedHashMap

LinkedHashMap сам позаботится о порядке доступа

Шаг 3: Тестирование
        java
SimpleCache<String, Integer> cache = new SimpleCache<>(2);
cache.put("A", 1);
cache.put("B", 2);
cache.get("A");     // A становится "моложе"
cache.put("C", 3);  // B должен удалиться (он самый старый)
💡 Подсказки:
removeEldestEntry вызывается после каждой операции put

size() возвращает текущее количество элементов

Сравнивай size() с capacity в removeEldestEntry
 */