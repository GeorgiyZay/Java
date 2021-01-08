package com.zaitsev.task2;

import com.zaitsevGeorgii.task2.ListArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListArrayTest {

    @Test
    @DisplayName("метод isEmpty когда список пуст")
    void testIsEmptyListTrue() {
        ListArray list = new ListArray();
        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    @DisplayName("метод isEmpty когда список не пуст")
    void testIsEmptyListFalse() {
        ListArray list = new ListArray();
        list.add('A');
        Assertions.assertEquals(false, list.isEmpty());
    }

    @Test
    @DisplayName("метод contains когда элемент не содержиться в списке")
    void testContainsListFalse() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        Assertions.assertEquals(false, list.contains('B'));
    }

    @Test
    @DisplayName("метод contains когда элемент содержиться в списке")
    void testContainsListTrue() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        Assertions.assertEquals(true, list.contains('b'));
    }

    @Test
    @DisplayName("метод size")
    void testSizeList() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @DisplayName("метод add в конец списка")
    void testAddToEndOfList() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertEquals('b', list.get(1));
    }


    @Test
    @DisplayName("метод remove удаление элемента")
    void testRemoveElement() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertEquals('b', list.remove(1));
    }

    @Test
    @DisplayName("метод remove удаление по отрицательному индексу")
    void testRemoveByNegativeElement() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.remove(-1));
    }

    @Test
    @DisplayName("метод remove удаление по индексу, большему размера списка")
    void testRemoveByLargeIndexElement() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.remove(3));
    }

    @Test
    @DisplayName("метод add добавление на отрицательную позицию")
    void testAddByNegativeIndex() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.add(-1, "dsffd"));
    }

    @Test
    @DisplayName("метод add добавление на позицию которая больше размера списка")
    void testAddByLargeIndex() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.add(4, "dsffd"));
    }

    @Test
    @DisplayName("метод add в начало списка")
    void testAddByIndexZero() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        list.add(0, 's');
        Assertions.assertEquals('s', list.get(0));
    }

    @Test
    @DisplayName("метод add в конец списка")
    void testAddToEnd() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        list.add(3, 's');
        Assertions.assertEquals('s', list.get(3));
    }

    @Test
    @DisplayName("метод get по отрицательнону индексу")
    void testGetByNegativeIndex() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.get(-1));
    }

    @Test
    @DisplayName("метод get по индексу который больше размера списка")
    void testGetByLargeIndex() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> list.get(4));
    }

    @Test
    @DisplayName("метод get из начала списка")
    void testGetByIndexZero() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        list.add(0, 's');
        Assertions.assertEquals('s', list.get(0));
    }

    @Test
    @DisplayName("метод get из конец списка")
    void testGetFromEnd() {
        ListArray list = new ListArray();
        list.add('A');
        list.add('b');
        list.add('C');
        list.add(3, 's');
        Assertions.assertEquals('s', list.get(3));
    }
}


