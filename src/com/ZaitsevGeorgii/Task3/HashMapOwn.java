package com.ZaitsevGeorgii.Task3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMapOwn implements java.util.Map {

    private HashTableOwn<Object, Object> table;

    public HashMapOwn(int size){
        table = new HashTableOwn<Object, Object>(size);
    }

    @Override
    public Object get(Object key) {
        return table.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return table.add(key, value);
    }

    @Override
    public boolean isEmpty() {
        return table.getSize() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return table.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("Не реализован");
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException("Не реализован");
    }
}
