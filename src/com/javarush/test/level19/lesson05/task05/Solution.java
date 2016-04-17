package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(rd.readLine()));

        String punctuationMarks = ",.:;\"\'(){}[]?!- \n";
        StringBuilder lineForWrite = new StringBuilder();

        while (fileRd.ready()) {
            char[] symbol = fileRd.readLine().toCharArray();

            for (char c : symbol) {
                if (!punctuationMarks.contains("" + c)) {
                    lineForWrite.append(c);
                }
            }
            fileWr.write(lineForWrite.toString());
            lineForWrite.delete(0, lineForWrite.length());
        }

        rd.close();
        fileRd.close();
        fileWr.close();
    }
}
