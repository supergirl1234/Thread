package com.stat;

import com.ISubject;
import com.RealSubject;

public class ProxySubject implements ISubject {
    public ISubject iSubject;

    public ProxySubject(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    public void before() {

        System.out.println("出门");
    }

    @Override
    public void eat() {
        before();
        this.iSubject.eat();
        after();
    }

    public void after() {

        System.out.println("回家");
    }

    public static void main(String[] args) {

        ProxySubject proxySubject=new ProxySubject(new RealSubject());
        proxySubject.eat();
    }
}
