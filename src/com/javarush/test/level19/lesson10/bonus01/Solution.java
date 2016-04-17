package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(fileName.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName.readLine()));
        fileName.close();
        List<String> fromFile1 = new ArrayList<>();
        List<String> fromFile2 = new ArrayList<>();

        while (file1.ready()) {
            fromFile1.add(file1.readLine());
        }
        file1.close();

        while (file2.ready()) {
            fromFile2.add(file2.readLine());
        }
        file2.close();
        int i = 0, j = 0;

        while (i < fromFile1.size() && j < fromFile2.size()) {
            if (fromFile1.get(i).equals(fromFile2.get(j))) {
                lines.add(new LineItem(Type.SAME, fromFile1.get(i)));
                i++;
                j++;
            } else if (j + 1 < fromFile2.size() && fromFile1.get(i).equals(fromFile2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, fromFile2.get(j++)));
            } else {
                lines.add(new LineItem(Type.REMOVED, fromFile1.get(i++)));
            }
        }

        if (i < fromFile1.size()) {
            lines.add(new LineItem(Type.REMOVED, fromFile1.get(i++)));
        } else if (j < fromFile2.size()){
            lines.add(new LineItem(Type.ADDED, fromFile2.get(j++)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }
}
