package com.zaitsevGeorgii.task5;

import java.io.*;

import static java.lang.Math.*;

public class Solver implements Runnable {
    private double[] a;
    private double[] b;
    private double[] c;
    private int start;
    private int end;
    private Pool<Thread> tPool;
    private Pool<FileWriter> fPool;

    public Solver(double[] a, double[] b, double[] c, int start, int end, Pool<Thread> tPool, Pool<FileWriter> fPool) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.start = start;
        this.end = end;
        this.tPool = tPool;
        this.fPool = fPool;
    }

    @Override
    public void run() {
        try(FileWriter writer = fPool.getResourse()){
            for (int i = start; i < end; i++){
                writer.write(getRoot(a[i], b[i], c[i]));
            }
            fPool.realize(writer);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void execute(Runnable runnable) {
        Thread workThread = tPool.getResourse();
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tPool.realize(workThread);
    }

    private String getRoot(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d >= 0) {
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        return "R\n";
                    } else {
                        return "Уравнение не имеет решение";
                    }
                } else {
                    return (new Double(-c / b)).toString() + '\n';
                }
            } else {
                if (d == 0) {
                    return "x_1 = x_2 = " + (new Double(-b / (2 * a))).toString() + '\n';
                } else {
                    return "x_1 = " + (new Double((-b + sqrt(d)) / (2 * a))).toString() +
                            " x_2 = " + (new Double((-b - sqrt(d)) / (2 * a))).toString() + '\n';
                }
            }
        } else {
            return "Отрицаткльный дискрименант\n";
        }

    }
}
