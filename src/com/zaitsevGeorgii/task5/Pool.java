package com.zaitsevGeorgii.task5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Pool<V> {
    private LinkedBlockingQueue<ResoursePoolItem<V, Long>> poolReourses;
    private LinkedBlockingQueue<ResoursePoolItem<V, Long>> usingResourses;
    private ObjectFactory<V> factory;
    private ExecutorService executorService;
    private long waintTime;
    private boolean isShutDown;
    private int size;

    public Pool(ObjectFactory<V> factory, int size, long waintTime) {
        poolReourses = new LinkedBlockingQueue<>(size);
        usingResourses = new LinkedBlockingQueue<>();
        executorService = Executors.newCachedThreadPool();
        this.factory = factory;
        this.waintTime = waintTime;
        isShutDown = false;
        this.size = size;
        initializationPool();
    }

    public void initializationPool() {
        for (int i = 0; i < size; i++) {
            poolReourses.add(new ResoursePoolItem<>(factory.create(), System.currentTimeMillis()));
        }
    }

    public void shutDown() {
        isShutDown = true;
        executorService.shutdownNow();
    }

    public ResoursePoolItem<V, Long> createResourse() {
        ResoursePoolItem<V, Long> resourse = new ResoursePoolItem<>(factory.create(), System.currentTimeMillis());
        if (poolReourses.add(resourse)) {
            return resourse;
        } else {
            System.out.println("Ошибка, невозможно добавить новый ресурс.");
            return null;
        }
    }

    public V getResourse() {
        if (isShutDown) {
            throw new IllegalStateException("Пул прекращенн");
        } else {
            try {
                ResoursePoolItem<V, Long> resourse = poolReourses.take();
                if (resourse.isAlive(waintTime)) {
                    usingResourses.offer(resourse);
                    return resourse.getValue();
                } else {
                    ResoursePoolItem<V, Long> newResourse = createResourse();
                    if (newResourse == null) {
                        return null;
                    }
                    usingResourses.offer(newResourse);
                    return newResourse.getValue();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public void realize(V value) {
        if (value == null) {
            throw new NullPointerException();
        } else if (isShutDown) {
            throw new IllegalStateException("Пул прекращенн");
        } else {
            usingResourses.remove(value);
            poolReourses.offer(new ResoursePoolItem<>(value, System.currentTimeMillis()));
        }
    }
}
