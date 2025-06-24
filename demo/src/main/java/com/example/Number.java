package com.example;

public class Number {
    public int i;
}

class Main {
    public static void main(String[] args) throws Exception {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.i = 2;
        n2.i = 5;
        n1 = n2;       // n1 now refers to the same object as n2
        n2.i = 10;     // modifies the object both n1 and n2 refer to
        System.out.println(n2.i);  // Output: 10
        n1.i = 20;     // again modifies the same object
        System.out.println(n1.i);  // Output: 20
    }
}
