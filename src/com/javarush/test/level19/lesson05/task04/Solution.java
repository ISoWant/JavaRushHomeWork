package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(rd.readLine()));
        rd.close();

        while (fileRd.ready()) {
            String line = fileRd.readLine().replace('.', '!');
            fileWr.write(line + '\n');
        }

        fileRd.close();
        fileWr.close();
    }
}
