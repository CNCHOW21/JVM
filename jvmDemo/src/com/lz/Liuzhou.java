package com.lz;

public class Liuzhou extends TestAbstract {
    public static void main(String[] args) {
        TestAbstract lz = new Liuzhou();
        System.out.println(lz.getName());
        System.out.println(lz.getSex());
        System.out.println(lz.getSkin());
        System.out.println(lz.getRelation());


        NaNa nana = new NaNa();
        System.out.println(nana.getName());
        System.out.println(nana.getSex());
        System.out.println(nana.getSkin());
        System.out.println(nana.getRelation());
    }

    @Override
    public String getName() {
        return "刘舟";
    }

    @Override
    public String getSex() {
        return "男";
    }

}