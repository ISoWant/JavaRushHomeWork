package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(rd.readLine()));
        rd.close();

        String punctuationMarks = ",. ;:\'\"(){}[]!?\n-";

        while (fileRd.ready()) {
            char[] symbols = fileRd.readLine().toCharArray();
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < symbols.length; i++) {
                if ((punctuationMarks.contains("" + symbols[i]) || i == symbols.length - 1)  && !word.equals("")) {
                    try {
                        if (i == symbols.length - 1 && !fileRd.ready()) {
                            word.append(symbols[i]);
                        }
                        int number = Integer.valueOf(word.toString());
                        fileWr.write(number + " ");
                        word.delete(0, word.length());
                    } catch (NumberFormatException e) {
                        word.delete(0, word.length());
                    }
                } else {
                    word.append(symbols[i]);
                }
            }

        }

        fileRd.close();
        fileWr.close();
    }
}
