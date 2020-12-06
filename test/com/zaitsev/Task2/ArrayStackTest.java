package com.zaitsev.Task2;

import com.ZaitsevGeorgii.Task2.ArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    @DisplayName("метод empty пустой")
    void testEmptyStackTrue() {
        ArrayStack stack = new ArrayStack();
        Assertions.assertEquals(true, stack.empty());
    }

    @Test
    @DisplayName("метод empty не пустой")
    void testEmptyStackFalse() {
        ArrayStack stack = new ArrayStack();
        stack.push('A');
        Assertions.assertEquals(false, stack.empty());
    }

    @Test
    @DisplayName("метод size")
    void testSize() {
        ArrayStack stack = new ArrayStack();
        stack.push('S');
        stack.push('A');
        stack.push('B');
        stack.pop();
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("метод pop из пустого стека")
    void testPopFromEmptyStack() {
        ArrayStack stack = new ArrayStack();
        Assertions.assertEquals(null, stack.pop());
    }

    @Test
    @DisplayName("метод pop из  стека")
    void testPopFromStack() {
        ArrayStack stack = new ArrayStack();
        stack.push('S');
        stack.push('A');
        stack.push('B');
        stack.pop();
        Assertions.assertEquals('A', stack.pop());
    }

    @Test
    @DisplayName("метод peek из пустого стека")
    void testPeekFromEmptyStack() {
        ArrayStack stack = new ArrayStack();
        Assertions.assertEquals(null, stack.peek());
    }

    @Test
    @DisplayName("метод peek из  стека")
    void testPeekFromStack() {
        ArrayStack stack = new ArrayStack();
        stack.push('S');
        stack.push('A');
        stack.push('B');
        stack.pop();
        Assertions.assertEquals('A', stack.peek());
    }

    @Test
    @DisplayName("метод push из  стека")
    void testPushToStack() {
        ArrayStack stack = new ArrayStack();
        stack.push('S');
        Assertions.assertEquals('S', stack.peek());
    }
}
