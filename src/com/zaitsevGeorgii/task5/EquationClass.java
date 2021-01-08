package com.zaitsevGeorgii.task5;

import java.io.FileWriter;

public class EquationClass {
    public static void main(String[] args) {
        long waintTime = 1000;
        int poolSize = Runtime.getRuntime().availableProcessors();
        double[] a = new double[10000];
        double[] b = new double[10000];
        double[] c = new double[10000];
        Pool<Thread> tPool = new Pool<>(new ThreadFactory(), poolSize, waintTime);
        Pool<FileWriter> fPool = new Pool<>(new FileFactory("fortask5"), poolSize, waintTime);

        for (int i = 0; i < 10000; i++) {
            a[i] = (Math.random() * (10000 + 1)) - 1000;
            a[i] = (Math.random() * (10000 + 1)) - 1000;
            a[i] = (Math.random() * (10000 + 1)) - 1000;
        }
        for (int i = 0; i < poolSize; i++) {
            Solver solver = new Solver(a, b, c, i * 10000 / poolSize, (i + 1) / 10000 / poolSize, tPool, fPool);
            solver.execute(solver);
        }
        tPool.shutDown();
    }
}
