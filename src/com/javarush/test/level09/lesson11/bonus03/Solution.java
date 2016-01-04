package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                ints.add(Integer.parseInt(array[i]));
            } else {
                strings.add(array[i]);
            }
        }

        int size = ints.size();
        for (int i = 0; i < size - 1; i++) {
            int tmp = ints.get(i);
            for (int j = i + 1; j < size; j++) {
                if (tmp < ints.get(j)) {
                    ints.set(i, ints.get(j));
                    ints.set(j, tmp);
                    tmp = ints.get(i);
                }
            }
        }

        size = strings.size();
        for (int i = 0; i < size; i++) {
            String tmp = strings.get(i);
            for (int j = i; j < size; j++) {
                if (isGreaterThan(tmp, strings.get(j))) {
                    strings.set(i, strings.get(j));
                    strings.set(j, tmp);
                    tmp = strings.get(i);
                }
            }
        }

        int intIndex = 0;
        int stIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = ints.get(intIndex++).toString();
            } else {
                array[i] = strings.get(stIndex++);
            }
        }
        //напишите тут ваш код
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
