package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream dstFile = new FileOutputStream(rd.readLine());
        FileInputStream firstSrcFile = new FileInputStream(rd.readLine());
        FileInputStream secondSrcFile = new FileInputStream(rd.readLine());

        while (firstSrcFile.available() > 0) {
            dstFile.write(firstSrcFile.read());
        }

        while (secondSrcFile.available() > 0) {
            dstFile.write(secondSrcFile.read());
        }

        rd.close();
        dstFile.close();
        firstSrcFile.close();
        secondSrcFile.close();
    }
}
