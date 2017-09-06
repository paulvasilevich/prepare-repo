package com.belhard.utils;

public class Main {

    public static int a;
    public int b;
    public int c;
    public static int d = 24;

    public Main() {
        System.out.println((this.toString()));
        this.a = 11;
        this.b = 12;
        this.c = 13;
        this.d = 14;
        System.out.println(this.toString());

    }

     {
        a = 1;
        b = 2;
        c = 3;
        d = 4;
    }

    @Override
    public String toString() {
        return "Main{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    static {
        a = 10;
        d = 6;
    }

    public static void main(String[] args) {
        Main my = new Main();
    }
}
