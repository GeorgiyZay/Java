package com.zaitsevGeorgii.task5;

public class ThreadFactory extends ObjectFactory<Thread> {
    @Override
    public Thread create(){
        return new Thread();
    }
}
