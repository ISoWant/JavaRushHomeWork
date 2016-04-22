package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream file = new FileInputStream(fileName);
        Map<Integer, Integer> counter = new HashMap<>();
        Integer current;
        int max = 0;

        while (file.available() > 0) {
            current = file.read();
            if (counter.containsKey(current)) {
                counter.put(current, counter.get(current) + 1);
            } else {
                counter.put(current, 1);
            }
        }

        for (Integer next : counter.values()) {
            if (max < next) {
                max = next;
            }
        }

        for (Integer key : counter.keySet()) {
            if (counter.get(key) == max) {
                System.out.print(key + " ");
            }
        }

        rd.close();
        file.close();
    }
}
