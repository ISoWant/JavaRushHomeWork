package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName.readLine()));
        fileName.close();

        while (fileRd.ready()) {
            String line = fileRd.readLine();
            System.out.println(reverse(line));
        }

        fileRd.close();

    }

    private static String reverse(String line) {
        char[] chars = line.toCharArray();
        String result = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }

        return result;
    }
}
