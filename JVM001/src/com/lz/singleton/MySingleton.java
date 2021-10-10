package com.lz.singleton;

import sun.misc.Launcher;

/**
 * 单例模式
 */
public class MySingleton {

    private static MySingleton mySingleton = new MySingleton();//初始化时，生成对象

    private MySingleton(){};//私有化构造器

    public static MySingleton getLauncher(){
        return mySingleton;
    }

    public static void main(String[] args) {
        System.out.println(getLauncher());
        System.out.println(getLauncher());
    }
}
