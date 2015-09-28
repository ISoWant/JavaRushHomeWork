package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        String s;

        for (int index = 0; index < 5; index++) {
            strings.add(reader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            s = strings.get(4);
            strings.remove(4);
            strings.add(0,s);
        }

        for (int index = 0; index < strings.size(); index++) {
            System.out.println(strings.get(index));
        }
        //напишите тут ваш код

    }
}
