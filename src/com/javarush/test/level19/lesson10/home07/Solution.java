package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder outString = new StringBuilder();

        while (fileRd.ready()) {
            String line = fileRd.readLine();
            String[] words = line.split(" ");

            for (String word : words) {
                if (word.length() > 6) {
                    if (outString.length() == 0) {
                        outString.append(word);
                    } else {
                        outString.append("," + word);
                    }
                }
            }
        }
        fileWr.write(outString.toString());

        fileRd.close();
        fileWr.close();
    }
}
