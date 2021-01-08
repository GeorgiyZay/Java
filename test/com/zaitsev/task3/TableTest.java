package com.zaitsev.task3;

import com.zaitsevGeorgii.task3.HashTableOwn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableTest {

    @Test
    void testContainsTrue() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(7, 12);
        Assertions.assertEquals(true, table.contains(7));
    }

    @Test
    void testContainsFalse() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(7, 12);
        Assertions.assertEquals(false, table.contains(5));
    }

    @Test
    void testAddd() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(3, 20);
        Assertions.assertEquals(20, table.get(3));
        Assertions.assertEquals(1, table.getSize());
    }

    @Test
    void testNegativeKeyRemove() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(7, 12);
        Assertions.assertThrows(NullPointerException.class, () -> table.remove(-5));
    }

    @Test
    void testNotExistKeyRemove() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(7, 12);
        Assertions.assertThrows(NullPointerException.class, () -> table.remove(5));
    }

    @Test
    void testRemove() {
        HashTableOwn<Integer, Integer> table = new HashTableOwn<Integer, Integer>(11);
        table.add(3, 15);
        table.add(3, 20);
        Assertions.assertEquals(20, table.remove(3));
        Assertions.assertEquals(0, table.getSize());
    }
}
