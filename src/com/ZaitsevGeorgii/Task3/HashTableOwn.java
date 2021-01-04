package com.ZaitsevGeorgii.Task3;

import java.util.ArrayList;

public class HashTableOwn<K, V> {

    private static class NodeOfHash<K, V> {
        NodeOfHash<K, V> next;
        K key;
        V value;

        public NodeOfHash(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<NodeOfHash<K, V>> table;
    private int size;

    public int getSize(){
        return size;
    }


    public HashTableOwn(int size) {
        table = new ArrayList<NodeOfHash<K, V>>();
        this.size = 0;
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % table.size());
    }

    public V get(K key) {

        if (contains(key)) {
            NodeOfHash<K, V> node = table.get(getIndex(key));

            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        NodeOfHash<K, V> node = table.get(getIndex(key));

        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V remove(K key) {
        NodeOfHash<K, V> node = table.get(getIndex(key));
        NodeOfHash<K, V> prevNode = null;
        while (node != null) {
            if (node.key.equals(key)) {
                break;
            }
            prevNode = node;
            node = node.next;
        }
        if (node == null) {
            throw new NullPointerException("Не существует элемента с таким ключом");
        } else if (prevNode != null) {
            prevNode.next = node.next;
        } else {
            table.set(getIndex(key), node.next);
        }
        size--;
        return node.value;
    }

    public V add(K key, V value){
        if ( (key == null) || (value == null)){
            throw new NullPointerException();
        }
        int ind = getIndex(key);
        NodeOfHash<K, V> node = table.get(ind);

        while (node != null) {
            if (node.key.equals(key)) {
                V prevValue = node.value;
                node.value = value;
                return  prevValue;
            }
            node = node.next;
        }
        node = new NodeOfHash<K, V>(key, value);
        if (table.get(ind) != null){
            node.next = table.get(ind);
        }
        size++;
        table.set(ind, node);
        return null;
    }
}

