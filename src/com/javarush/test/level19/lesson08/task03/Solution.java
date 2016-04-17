package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream myOutput = new PrintStream(byteArray);
        System.setOut(myOutput);

        testString.printSomething();

        System.setOut(systemOut);

        String digits = "1234567890";
        String result = byteArray.toString();
        StringBuilder numbers = new StringBuilder();
        char[] charsOfResult = result.toCharArray();

        for (int i = 0; i < charsOfResult.length; i++) {
            if (digits.contains("" + charsOfResult[i])) {
                numbers.append(charsOfResult[i]);
            }
        }

        System.out.println(numbers);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
