package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream srcFile = new FileInputStream(rd.readLine());
        FileOutputStream dstFile = new FileOutputStream(rd.readLine());
        FileOutputStream secondDstFile = new FileOutputStream(rd.readLine());

        byte[] buffer = new byte[srcFile.available()];
        int count = srcFile.read(buffer);
        int middle = count % 2 > 0 ? count / 2 + 1 : count / 2;

        dstFile.write(buffer, 0, middle);
        secondDstFile.write(buffer, middle, count - middle);

        rd.close();
        srcFile.close();
        dstFile.close();
        secondDstFile.close();
    }
}
