package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        rd.close();
        String punctuationMarks = ",.?!:;\"\'(){}[]&- \n";
        int count = 0;

        while (fileRd.ready()) {
            char[] symbols = fileRd.readLine().toCharArray();
            String worb = "";
            for (int i = 0; i < symbols.length; i++) {
                if (punctuationMarks.contains("" + symbols[i])) {
                    if (worb.equals("world")) {
                        count++;
                    }
                    worb = "";
                } else {
                    worb += symbols[i];

                    if (i == symbols.length - 1) {
                        if (worb.equals("world")) {
                            count++;
                        }
                    }
                }
            }
        }
        fileRd.close();
        System.out.println(count);
    }
}
