package com.zaitsevGeorgii.task5;

public class ResoursePoolItem<V, Long> {

    private V value;
    private long time;

    public ResoursePoolItem(V value, long time){
        this.value = value;
        this.time = time;
    }

    public V getValue(){
        return value;
    }

    public long getTime(){
        return time;
    }

    public boolean isAlive(long waitTime){
        long currentTime = System.currentTimeMillis();
        return currentTime - this.time < waitTime;
    }
}
