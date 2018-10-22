package com.sun.concurrency.singleton;

import com.sun.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:40
 */
@Slf4j
@NotThreadSafe
/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static  SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
