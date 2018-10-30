package com.sun.concurrency.commonUnSafe;

import com.sun.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 18:44
 */
@Slf4j
@ThreadSafe
public class DateFormatExample2 {

        //请求总数
        public static int clientTotal = 5000;

        //同时并发执行的线程数
        public static int threadTotal = 200;

        public static void main(String[] args) throws InterruptedException {
            ExecutorService executorService = Executors.newCachedThreadPool();
            final Semaphore semaphore = new Semaphore(threadTotal);
            final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
            for (int i = 0; i < clientTotal; i++){
                executorService.execute(() ->{
                    try {
                        semaphore.acquire();
                        update();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        log.info("exception",e);
                    }
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
            executorService.shutdown();

        }

        public static void  update() {
            try {
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            } catch (Exception e) {
                log.error("parser exception",e);
            }
        }
    }
