package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String dstFileName = rd.readLine();

        FileInputStream dstFileForRead = new FileInputStream(dstFileName);
        int count = dstFileForRead.available();
        byte[] buffer = new byte[count];
        dstFileForRead.read(buffer, 0, count);

        FileOutputStream dstFile = new FileOutputStream(dstFileName);

        FileInputStream srcFile = new FileInputStream(rd.readLine());
        rd.close();

        while (srcFile.available() > 0) {
            dstFile.write(srcFile.read());
        }
        dstFile.write(buffer);

        dstFileForRead.close();
        dstFile.close();
        srcFile.close();

    }
}
