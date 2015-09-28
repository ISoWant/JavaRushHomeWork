package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = 0;
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).length() > length) {
                length = list.get(index).length();
            }
        }

        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).length() == length) {
                System.out.println(list.get(index));
            }
        }
    }
}
