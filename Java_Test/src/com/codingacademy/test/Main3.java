package com.codingacademy.test;

public class Main3 {
    public static void main(String[] args) {
        Greet g = new Greet();
        g.greet("Name");
        boolean a = g instanceof Greet;
        System.out.println(a);
    }
}
