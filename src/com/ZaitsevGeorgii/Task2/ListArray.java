package com.ZaitsevGeorgii.Task2;

import java.lang.reflect.Array;
import java.util.*;

public class ListArray implements List {

    private Object[] array;
    private int size;


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size){
            throw  new ArrayIndexOutOfBoundsException("");
        }
        else{
            Object removeValue = array[index];
            for (int i = index; i < size - 1; i++){
                array[i] = array[i + 1];
            }
            array = Arrays.copyOf(array, array.length - 1);
            size--;
            return removeValue;
        }
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size ){
            throw new ArrayIndexOutOfBoundsException("");
        }
        else  if(size == 0){
            size++;
            array = new Object[1];
            array[0] = element;
        }
        else{
            array = Arrays.copyOf(array, array.length + 1);
            for (int i = size - 2; i>index; i++){
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
        if (this.size == 0){
            this.size = 1;
            array = new Object[1];
            array[0] = o;
        }
        else{
            array = Arrays.copyOf(array, array.length + 1);
            array[size] = o;
            size++;
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size){
            throw  new ArrayIndexOutOfBoundsException();
        }
        else {
            return array[index];
        }
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            if (array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public Object set(int index, Object element) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
