package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int maximum;
        int minimum;
        int tmp;

        for (int i = 0; i < 20; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        minimum = maximum = numbers.get(0);
        for (int index = 0; index < numbers.size(); index++) {
            tmp = numbers.get(index);

            if (tmp < minimum) {
                minimum = tmp;
            } else if (tmp > maximum) {
                maximum = tmp;
            }
        }

        System.out.println(maximum + " " + minimum);
    }
}
