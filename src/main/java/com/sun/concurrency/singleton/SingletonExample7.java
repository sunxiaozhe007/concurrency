package com.sun.concurrency.singleton;

import com.sun.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:40
 */

/**
 * 枚举模式：最安全
 */
@ThreadSafe
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton(){
            return singleton;
        }
    }
}
