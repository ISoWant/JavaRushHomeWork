package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        Random rand = new Random();
        Integer integer = rand.nextInt();

        System.out.println(print(10));
        System.out.println(print(integer));
    }

    private static int print(int n) {
        return n;
    }

    private static Integer print(Integer integer) {
        return integer;
    }

    //Напишите тут ваши методы
}
