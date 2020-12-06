package com.ZaitsevGeorgii.Task2;

public class ArrayStack extends java.util.Stack {
    private ListArray array;

    public ArrayStack(){
        array = new ListArray();
    }

    @Override
    public boolean empty(){
        return array.isEmpty();
    }

    @Override
    public Object peek(){
        if (array.isEmpty()){
            return null;
        }
        else{
            return array.get(array.size() - 1);
        }
    }

    @Override
    public Object pop(){
        if (array.isEmpty()) {
            return null;
        }
        else{
            return array.remove(array.size() - 1);
        }
    }

    @Override
    public Object push(Object element){
        array.add(element);
        return element;
    }

    @Override
    public int size(){
        return array.size();
    }
}
