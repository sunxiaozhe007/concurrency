package com.sun.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 14:41
 */
@Slf4j
public class SynchronizedExample {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                log.info("test - {} - {}",j,i);
            }
        }
    }
    //修饰一个方法
    public synchronized void test2(int j){
            for (int i = 0; i < 10; i++){
                log.info("test - {} - {}",j,i);
            }
    }

    public static void main(String[] args) {
        SynchronizedExample example1 = new SynchronizedExample();
        SynchronizedExample example2 = new SynchronizedExample();
         ExecutorService executorService = Executors.newCachedThreadPool();

         executorService.execute(() ->{
             example1.test2(1);
         });

         executorService.execute(() ->{
             example2.test2(2);
         });
    }
}
