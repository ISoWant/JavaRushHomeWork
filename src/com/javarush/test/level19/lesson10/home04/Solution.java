package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputStremReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(inputStremReader.readLine()));
        inputStremReader.close();
        int count = 0;
        String line;

        while (fileRd.ready()) {
            line = fileRd.readLine();
            String[] word = line.split(" ");

            for (int i = 0; i < word.length; i++) {
                if (words.contains(word[i])) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println(line);
            }
            count = 0;
        }

        fileRd.close();
    }
}
