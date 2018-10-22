package com.sun.concurrency.singleton;

import com.sun.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:40
 */
@Slf4j
@ThreadSafe
/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
