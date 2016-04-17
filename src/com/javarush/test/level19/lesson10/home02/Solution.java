package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> state = new HashMap<>();
        String position;
        Double value, maxValue = Double.MIN_VALUE;

        while (fileRd.ready()) {
            position = fileRd.readLine();
            String[] parameter = position.split(" ");

            if (state.containsKey(parameter[0])) {
                value = state.get(parameter[0]) + Double.valueOf(parameter[1]);
            } else {
                value = Double.valueOf(parameter[1]);
            }
            state.put(parameter[0], value);

            if (value > maxValue) {
                maxValue = value;
            }
        }

        fileRd.close();

        for (String name : state.keySet()) {
            if ((double)state.get(name) == (double)maxValue) {
                System.out.println(name);
            }
        }
    }
}
