package com.codingacademy.test;

public class Execute {
    public static void main(String[] args) {
        Dog maltese = new Dog();
        maltese.breed = "Maltese";
        maltese.size = "small";
        maltese.age = 3;
        maltese.color = "White";
        System.out.println(maltese.getInfo());
    }
}
