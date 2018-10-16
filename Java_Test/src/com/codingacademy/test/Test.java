package com.codingacademy.test;


public class Test {

    public static void main(String args[]) {
        int num = 13;
        boolean is_prime = true;


        for (int i = 2; i < num / 2; i++) {
            if ( (num % i) == 0 ) {
                is_prime = false;
                break;
            }
        }
        if ( is_prime ) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }

        drawLine(10);
    }

    static void drawLine(){

    }

    static void drawLine(int width){

    }
}
