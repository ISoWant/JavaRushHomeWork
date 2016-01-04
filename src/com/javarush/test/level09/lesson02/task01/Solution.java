package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();

        StackTraceElement[] ste1 = Thread.currentThread().getStackTrace();
        return ste1;
        //напишите тут ваш код

    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] ste2 = Thread.currentThread().getStackTrace();
        return ste2;
        //напишите тут ваш код

    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] ste3 = Thread.currentThread().getStackTrace();
        return ste3;
        //напишите тут ваш код

    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] ste4 = Thread.currentThread().getStackTrace();
        return ste4;
        //напишите тут ваш код

    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] ste5 = Thread.currentThread().getStackTrace();
        return ste5;
        //напишите тут ваш код
    }
}
