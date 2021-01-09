package com.zaitsev.task5;

import com.zaitsevGeorgii.task5.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

public class PoolTest {
    @Test
    void testGetResourseWhereShutDownPool() {
        Pool<Thread> pool = new Pool<>(new ThreadFactory(), 10, 1000);
        pool.shutDown();
        Assertions.assertThrows(IllegalStateException.class, () -> pool.getResourse());
    }

    @Test
    void testrealizeWhereShutDownPool() {
        Pool<Thread> pool = new Pool<>(new ThreadFactory(), 10, 1000);
        Thread current = pool.getResourse();
        pool.shutDown();
        Assertions.assertThrows(IllegalStateException.class, () -> pool.realize(current));
    }

    @Test
    void testCorrectConstructor() {
        Pool<Thread> pool = new Pool<>(new ThreadFactory(), 12, 1000);
        Assertions.assertEquals(12, pool.size());
    }

    @Test
    void testNullRealize() {
        Pool<Thread> pool = new Pool<>(new ThreadFactory(), 12, 1000);
        Assertions.assertThrows(NullPointerException.class, () -> pool.realize(null));
    }
}
