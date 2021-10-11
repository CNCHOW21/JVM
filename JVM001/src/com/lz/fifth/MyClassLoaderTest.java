package com.lz.fifth;

import java.io.FileInputStream;
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

        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)){
                Class<?> c = findLoadedClass(name);

                if(c == null){
                    long t1 = System.nanoTime();
                    c = findClass(name);//不存在则直接在自己的classLoad中寻找，不委托父类

                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if(resolve){
                    resolveClass(c);
                }
                return c;
            }
        }

        public static void main(String[] args) throws Exception {
            MyClassLoaderTest.MyClassLoader classLoader = new com.lz.fifth.MyClassLoaderTest.MyClassLoader("F:/test");
            Class clazz = classLoader.loadClass("java.lang.String");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("getSex",null);
            method.invoke(obj,null);
            System.out.println(clazz.getClassLoader().getClass().getName());
            System.out.println(clazz.getClassLoader().getParent().getClass().getName());
        }
    }
}
