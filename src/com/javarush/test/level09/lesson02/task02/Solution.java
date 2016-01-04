package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();

        StackTraceElement[] ste1 = Thread.currentThread().getStackTrace();

        return ste1[2].getMethodName();
        //напишите тут ваш код

    }

    public static String method2() {
        method3();

        StackTraceElement[] ste2 = Thread.currentThread().getStackTrace();

        //напишите тут ваш код
        return ste2[2].getMethodName();

    }

    public static String method3() {
        method4();

        StackTraceElement[] ste3 = Thread.currentThread().getStackTrace();
        //напишите тут ваш код
        return ste3[2].getMethodName();

    }

    public static String method4() {
        method5();

        StackTraceElement[] ste4 = Thread.currentThread().getStackTrace();
        //напишите тут ваш код
        return ste4[2].getMethodName();

    }

    public static String method5() {

        StackTraceElement[] ste5 = Thread.currentThread().getStackTrace();
        //напишите тут ваш код
        return ste5[2].getMethodName();

    }
}
