package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.MissingFormatArgumentException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String st = rd.readLine();
        char[] chars = st.toCharArray();

        int start = st.indexOf("?");
        boolean flag = true, flagEq = false;
        String param = "", value = "";

        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] == '&') {
                if (flag) System.out.print(param + " ");
                flag = true;
                param = "";
            } else if (chars[i] == '=' && flag && !param.equals("obj")) {
                System.out.print(param + " ");
                flag = false;
                param = "";
            } else if (param.equals("obj") && (chars[i] == '=' || flagEq)) {
                if( chars[i] != '=') {
                    value += chars[i];
                } else flagEq = true;
            } else if (flag) {
                param += chars[i];
            }

            if (param.length() != 0 && i == chars.length - 1) {
                System.out.print(param);
            }
        }

        if (value.length() != 0) {
            System.out.println();
            try {
                double val = Double.valueOf(value);
                alert(val);
            } catch (NumberFormatException e) {
                alert(value);
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
