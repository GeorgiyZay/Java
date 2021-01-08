package com.zaitsev.task3;

import com.zaitsevGeorgii.task3.HashMapOwn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void testIsEmptyTrue(){
        HashMapOwn hashMap = new HashMapOwn(15);
        Assertions.assertEquals(true, hashMap.isEmpty());
    }

    @Test
    void testIsEmptyFalse(){
        HashMapOwn hashMap = new HashMapOwn(15);
        hashMap.put(3, 10);
        Assertions.assertEquals(false, hashMap.isEmpty());
    }

    @Test
    void testContains(){
        HashMapOwn hashMap = new HashMapOwn(15);
        hashMap.put(3, 10);
        hashMap.put(4, 2);
        hashMap.put(19, 5);
        Assertions.assertEquals(true, hashMap.containsKey(3));
        Assertions.assertEquals(false, hashMap.containsKey(18));
    }

    @Test
    void testPut(){
        HashMapOwn hashMap = new HashMapOwn(15);
        hashMap.put(3, 10);
        Assertions.assertEquals(10, hashMap.put(3, 14));
    }

    @Test
    void testGet(){
        HashMapOwn hashMap = new HashMapOwn(15);
        hashMap.put(3, 10);
        hashMap.put(4, 2);
        hashMap.put(19, 5);
        Assertions.assertEquals(10, hashMap.get(3));
        Assertions.assertEquals(null, hashMap.get(18));
    }
}
