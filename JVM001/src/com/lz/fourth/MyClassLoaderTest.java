package com.lz.fourth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replace(".","/");
            FileInputStream fis = new FileInputStream(classPath+"/"+name+".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        protected  Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name,data,0,data.length);
            }catch (Exception e){
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        public static void main(String[] args) throws Exception {
            MyClassLoader classLoader = new MyClassLoader("F:/test");
            Class clazz = classLoader.findClass("com.lz.first.User");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("getSex",null);
            method.invoke(obj,null);
            System.out.println(clazz.getClassLoader().getClass().getName());
            System.out.println(clazz.getClassLoader().getParent().getClass().getName());
        }
    }
}
