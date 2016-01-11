package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        OutputStream fOu = new FileOutputStream(rd.readLine());

        String data = "";

        while (!(data.equals("exit"))) {
            data = rd.readLine();
            char[] c = data.toCharArray();
            for (int i = 0; i < c.length; i++) {
                fOu.write((byte)c[i]);
            }

            if (!(data.equals("exit"))) fOu.write((byte)'\n');
        }

        rd.close();
        fOu.close();
    }
}
