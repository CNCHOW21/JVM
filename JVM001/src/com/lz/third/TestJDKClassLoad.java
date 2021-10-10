package com.lz.third;

import com.lz.singleton.MySingleton;
import sun.misc.Launcher;

import java.net.URL;

public class TestJDKClassLoad {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoad.class.getClassLoader().getClass().getName());

        System.out.println("----------------------------------------------");
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader:" + bootstrapLoader);
        System.out.println("the extClassLoader:" + extClassLoader);
        System.out.println("the appClassLoader:" + appClassLoader);
        System.out.println("----------------------------------------------");

        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }

        System.out.println("extClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));

    }
}
