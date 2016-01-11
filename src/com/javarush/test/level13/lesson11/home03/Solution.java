package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String st = read.readLine();

        InputStream inSt = new FileInputStream(st);

        while (inSt.available() > 0) {
            int data = inSt.read();
            System.out.print((char) data);
        }

        read.close();
        inSt.close();
    }
}
