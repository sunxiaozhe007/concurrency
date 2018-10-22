package com.sun.concurrency.Atomic;

import com.sun.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/21 15:16
 */
@ThreadSafe
@Slf4j
public class AtomicExample5 {
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5,100,120)){
            log.info("update success1,{}",example5.getCount());
        }
        if (updater.compareAndSet(example5,100,120)){
            log.info("update success2,{}",example5.getCount());
        }else {
            log.info("update failed,{}",example5.getCount());
        }
    }

}
