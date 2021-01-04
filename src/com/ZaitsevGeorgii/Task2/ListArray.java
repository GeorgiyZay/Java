package com.ZaitsevGeorgii.Task2;

import java.lang.reflect.Array;
import java.util.*;

public class ListArray implements List {

    private Object[] array;
    private int size;
    private int maxSize;

    public ListArray() {
        this.maxSize = 8;
        size = 0;
        array = new Object[this.maxSize];
    }

    public ListArray(int size) {
        this.maxSize = size;
        this.size = 0;
        array = new Object[this.maxSize];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс находится вне допустимого диапазона");
        } else {
            Object removeValue = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return removeValue;
        }
    }

    @Override
    public void add(int index, Object element) {
        if (element == null){
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс находится вне допустимого диапазона");
        } else {
            if (size == maxSize) {
                maxSize *= 2;
                array = Arrays.copyOf(array, maxSize);
            }
            for (int i = size - 2; i > index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = element;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if (o == null){
            throw new NullPointerException();
        }
        if (size == maxSize) {
            maxSize *= 2;
            array = Arrays.copyOf(array, maxSize);
        }
        array[size] = o;
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс находится вне допустимого диапазона");
        } else {
            return array[index];
        }
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Не реализован");
    }


    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Не реализован");
    }


    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Не реализован");
    }

}
