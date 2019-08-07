package com.dyamic;

import com.ISubject;
import com.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Prox implements InvocationHandler {

    /*目标对象*/
    public Object target;

    /*生成代理对象*/

    public Object newInstance(Object object){
        this.target=object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),this);


    }

    /*
    *
    *
    * proxy:被代理对象
    * 该方法是由系统自动调用的
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object=method.invoke(this.target,args);
        after();
        return  object;
    }

    public void before(){

        System.out.println("打扮");
    }
    public void after(){

        System.out.println("购物");
    }

    public static void main(String[] args) {
        ISubject prox= (ISubject) new Prox().newInstance(new RealSubject());
        prox.eat();
    }
}
