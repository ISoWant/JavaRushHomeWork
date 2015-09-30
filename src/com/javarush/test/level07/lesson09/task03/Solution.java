package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        String imenno = "именно";

        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        for (int i = 1; i < 6; i += 2) {
            strings.add(i, imenno);
        }

        for (int index = 0; index < strings.size(); index++) {
            System.out.println(strings.get(index));
        }
    }
}
