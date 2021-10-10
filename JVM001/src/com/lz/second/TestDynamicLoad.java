package com.lz.second;

public class TestDynamicLoad {
    static {
        System.out.println("********load TestDynamicLoad************");
    }

    public TestDynamicLoad() {
        System.out.println("********load TestDynamicLoad construct ************");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("**********************laod test***************");
        B b = null;
    }
}
