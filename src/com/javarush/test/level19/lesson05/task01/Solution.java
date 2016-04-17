package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileRd = new FileInputStream(rd.readLine());
        FileOutputStream fileWr = new FileOutputStream(rd.readLine());
        rd.close();

        int i = 1;
        int byteFromFile;

        while (fileRd.available() > 0) {
            byteFromFile = fileRd.read();
            if (i % 2 == 0) {
                fileWr.write(byteFromFile);
                i = 1;
            } else {
                i = 2;
            }
        }
        fileRd.close();
        fileWr.close();
    }
}
