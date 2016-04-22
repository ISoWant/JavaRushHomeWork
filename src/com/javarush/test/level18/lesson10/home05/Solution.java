package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream srcFile = new FileInputStream(rd.readLine());
        FileOutputStream dstFile = new FileOutputStream(rd.readLine());
        rd.close();
        String number = "";

        while (srcFile.available() > 0) {
            int symbol = srcFile.read();
            if (symbol == 32) {
                parser(number, dstFile);
                number = "";
            } else {
                number += (char)symbol;
            }
        }
        parser(number, dstFile);
        srcFile.close();
        dstFile.close();
    }

    private static void parser(String number, FileOutputStream dstFile) throws IOException {
        int result;
        float fractional = Float.valueOf(number);
        if (fractional >= 0.0) {
            float tmp = ((int) fractional) + 1;
            if (tmp - fractional <= 0.5)
                result = (int) tmp;
            else
                result = ((int) tmp) - 1;
        } else {
            float tmp = (-(int) fractional) + 1;
            if (tmp - -fractional < 0.5)
                result = -(int) tmp;
            else
                result = - ((int) tmp - 1);
        }
        String toFile = Integer.toString(result) + " ";
        dstFile.write(toFile.getBytes());
    }
}
