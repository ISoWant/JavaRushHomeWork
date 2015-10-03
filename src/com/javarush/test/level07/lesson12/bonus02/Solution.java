package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом она конвертирует строки в верхний регистр
         (Мама превращается в МАМА) и выводит их на экран.
Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
              Потом программа строит новый список. Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
              Программа выводит содержимое нового списка на экран.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listProd = new ArrayList<String>();
        for (int index = 0; index < list.size(); index++) {
            s = list.get(index);
            if (s.length() % 2 == 0) {
                listProd.add(s + " " + s);
            }
            else{
                listProd.add(s + " " + s + " " + s);
            }
        }

        for (int index = 0; index < listProd.size(); index++) {
            System.out.println(listProd.get(index));
        }
    }
}
