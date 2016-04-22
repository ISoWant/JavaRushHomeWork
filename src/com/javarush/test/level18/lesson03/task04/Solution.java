package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream file = new FileInputStream(fileName);
        Map<Integer, Integer> counter = new HashMap<>();
        Integer min = Integer.MAX_VALUE;

        while (file.available() > 0) {
            int current = file.read();

            if (counter.containsKey(current)) {
                counter.put(current, counter.get(current) + 1);
            } else {
                counter.put(current, 1);
            }
        }

        for (Integer next : counter.values()) {
            if (min > next) {
                min = next;
            }
        }

        for (Integer next : counter.keySet()) {
            if (counter.get(next) == min) {
                System.out.print(next + " ");
            }
        }

        rd.close();
        file.close();
    }
}
