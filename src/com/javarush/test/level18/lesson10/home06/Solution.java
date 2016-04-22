package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream srcFile = new FileInputStream(args[0]);

        Map<Integer, Integer> freak = new TreeMap<>();

        while (srcFile.available() > 0) {
            int symbol = srcFile.read();
            if (freak.containsKey(symbol)) {
                freak.put(symbol, freak.get(symbol) + 1);
            } else {
                freak.put(symbol, 1);
            }
        }

        for (Integer integer : freak.keySet()) {
            int i = integer;
            char c = (char) i;
            System.out.println(c + " " + freak.get(integer));
        }

        srcFile.close();
    }
}
