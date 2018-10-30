package com.sun.concurrency.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/24 16:06
 */
@Slf4j
public class DeadLock implements Runnable {

    public int flag = 1;

    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        log.info("flag:{}",flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    log.info("1");
                }
            }
        }
        if (flag == 0){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    log.info("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock t1 = new DeadLock();
        DeadLock t2 = new DeadLock();
        t1.flag = 1;
        t2.flag = 0;
        //t1,t2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的
        //t2的run（）可能在t1的run（）之前运行
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
