package com;

import com.ISubject;

public class RealSubject implements ISubject {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
