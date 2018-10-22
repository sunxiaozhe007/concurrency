package com.sun.concurrency.singleton;

import com.sun.concurrency.annoations.NotThreadSafe;
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
 * 懒汉模式 加入synchronized保证线程安全
 * 单例实例在第一次使用时进行创建
 */
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法  加入synchronized保证线程安全
    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
