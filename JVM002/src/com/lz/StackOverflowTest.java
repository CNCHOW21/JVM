package com.lz;

public class StackOverflowTest {
    static int count = 0;

    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) throws InterruptedException {
        try{
            redo();
            Thread.sleep(2000);
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println(count);
        }
    }
}
