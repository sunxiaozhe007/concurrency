package com.sun.concurrency.singleton;

import com.sun.concurrency.annoations.ThreadSafe;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:40
 */

/**
 * 正确的线程安全的单例模式
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }

    //1.memory = allocate()分配对象内存空间
    //2.ctorInstance（）初始化对象
    //3.instance = memory 设置instance指向刚分配的内存空间

    //单例对象 volatile + 双重检测机制 -》》禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态工厂方法
    public static SingletonExample5 getInstance(){
        if (instance == null){  //双重检测机制        //B线程判空后返回一个未被初始化的对象，出现线程安全问题
            synchronized (SingletonExample5.class){//同步锁
                if (instance == null){
                    instance = new SingletonExample5();//A线程执行步骤3，还没初始化
                }
            }
        }
        return instance;
    }
}
