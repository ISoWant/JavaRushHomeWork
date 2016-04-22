package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream srcFile = new FileInputStream(rd.readLine());
        FileOutputStream dstFile = new FileOutputStream(rd.readLine());
        byte[] buffer = new byte[srcFile.available()];
        int count = srcFile.read(buffer);

        for (int i = count - 1; i >= 0; i--) {
            dstFile.write(buffer[i]);
        }

        rd.close();
        srcFile.close();
        dstFile.close();
    }
}
