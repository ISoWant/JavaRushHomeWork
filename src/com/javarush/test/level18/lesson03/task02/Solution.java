package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream file = new FileInputStream(fileName);
        int current, min = 999;

        while (file.available() > 0) {
            current = file.read();

            if (min > current) {
                min = current;
            }
        }

        System.out.println(min);

        rd.close();
        file.close();
    }
}
