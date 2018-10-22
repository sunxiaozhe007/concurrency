package com.sun.concurrency.singleton;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 15:40
 */

/**
 * 懒汉模式---》双重同步锁单例模式
 */
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4(){

    }

    //1.memory = allocate()分配对象内存空间
    //2.ctorInstance（）初始化对象
    //3.instance = memory 设置instance指向刚分配的内存空间

    //JVM和cpu优化，发生指令重排序
    //第二步和第三部可以互换顺序
    //1.memory = allocate()分配对象内存空间
    //2.ctorInstance（）初始化对象
    //3.instance = memory 设置instance指向刚分配的内存空间

    //单例对象
    private static SingletonExample4 instance = null;

    //静态工厂方法
    public static SingletonExample4 getInstance(){
        if (instance == null){  //双重检测机制        //B线程判空后返回一个未被初始化的对象，出现线程安全问题
            synchronized (SingletonExample4.class){//同步锁
                if (instance == null){
                    instance = new SingletonExample4();//A线程执行步骤3，还没初始化
                }
            }
        }
        return instance;
    }
}
