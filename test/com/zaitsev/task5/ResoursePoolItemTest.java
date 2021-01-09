package com.zaitsev.task5;

import com.zaitsevGeorgii.task5.ResoursePoolItem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResoursePoolItemTest {

    @Test
    void testIsAliveFalse(){
        ResoursePoolItem<Integer, Long> resourse = new ResoursePoolItem<>(12, System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(false, resourse.isAlive(500));
    }

    @Test
    void testIsAliveTrue(){
        ResoursePoolItem<Integer, Long> resourse = new ResoursePoolItem<>(12, System.currentTimeMillis());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(true, resourse.isAlive(500));
    }
}
