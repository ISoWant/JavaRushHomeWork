package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(args[1]));
        String line;
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        while (fileRd.ready()) {
            line = fileRd.readLine();
            String[] words = line.split(" ");

            for (String word : words) {
                for (char digit : digits) {
                    if (word.contains("" + digit)) {
                        fileWr.write(word + " ");
                        break;
                    }
                }
            }
        }

        fileRd.close();
        fileWr.close();
    }
}
