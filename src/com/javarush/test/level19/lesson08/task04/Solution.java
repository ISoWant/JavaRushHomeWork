package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream outputArray = new ByteArrayOutputStream();
        PrintStream myOutput = new PrintStream(outputArray);
        System.setOut(myOutput);
        testString.printSomething();
        System.setOut(systemOut);
        String result = outputArray.toString();
        System.out.print(decide(result));
    }

    private static String  decide(String expression) {
        String[] members = expression.split(" ");
        int first = Integer.valueOf(members[0]);
        int second = Integer.valueOf(members[2]);
        int result = 0;

        switch (members[1]) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
        }
        String res = members[0] + " " + members[1] + " "
                + members[2] + " " + members[3] + " " + result;
        return res;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

