package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> payroll = new TreeMap<>();
        String position;

        while (fileRd.ready()) {
            position = fileRd.readLine();
            String[] parameter = position.split(" ");

            if (payroll.containsKey(parameter[0])) {
                Double value = payroll.get(parameter[0]) + Double.valueOf(parameter[1]);
                payroll.put(parameter[0], value);
            } else {
                payroll.put(parameter[0], Double.valueOf(parameter[1]));
            }
        }

        fileRd.close();

        for (String name : payroll.keySet()) {
            System.out.println(name + " " + payroll.get(name));
        }

    }
}
