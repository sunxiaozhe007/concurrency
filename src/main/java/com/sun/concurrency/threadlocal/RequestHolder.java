package com.sun.concurrency.threadlocal;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 17:03
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();


    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
