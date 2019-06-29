package com.mutexThread;

/**
 * Author:Fanleilei
 * Created:2019/6/29 0029
 */

class  TicketSale implements Runnable{


    private  int ticket=20;
    @Override
    public void run() {

        //需要在条件处某一时刻只有一个线程，需要为程序段上锁
        while(this.ticket>0){
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("还剩下"+ticket--+"张票");
        }
    }
}
public class SellTicket {

    public static void main(String[] args) {

        TicketSale ticketSale=new TicketSale();
        Thread thread1=new Thread(ticketSale,"黄牛1");
        Thread thread2=new Thread(ticketSale,"黄牛2");
        Thread thread3=new Thread(ticketSale,"黄牛3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
