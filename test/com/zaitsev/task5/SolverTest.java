package com.zaitsev.task5;

import com.zaitsevGeorgii.task5.Solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SolverTest {

    @Test
    public void testNegativeDisc() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("Отрицаткльный дискрименант\n", solver.getRoot(1, 1, 1));
    }

    @Test
    public void testDiscZero() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("x_1 = x_2 = 1.0\n", solver.getRoot(1, -2, 1));
    }

    @Test
    public void testAllZeroCoef() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("R\n", solver.getRoot(0, 0, 0));
    }

    @Test
    public void testAZero() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("-2.0\n", solver.getRoot(0, 1, 2));
    }

    @Test
    public void testABZero() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("Уравнение не имеет решение\n", solver.getRoot(0, 0, 2));
    }

    @Test
    public void testNormal() {
        Solver solver = new Solver(null, null, null, 0, 0, null, null);
        Assertions.assertEquals("x_1 = 3.0 x_2 = 2.0\n", solver.getRoot(1, -5, 6));
    }
}
