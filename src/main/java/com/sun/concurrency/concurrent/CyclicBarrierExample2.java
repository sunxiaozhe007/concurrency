package com.sun.concurrency.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/23 18:39
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() ->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                   log.error("exception");
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        barrier.await(2000,TimeUnit.MILLISECONDS);
        log.info("{} continue",threadNum);
    }
}
