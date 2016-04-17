package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));
        String position;
        int day, month, year;

        while (fileRd.ready()) {
            position = fileRd.readLine();
            String[] parameters = position.split(" ");

            StringBuilder name = new StringBuilder(parameters[0]);

            for (int i = 1; i < parameters.length - 3; i++) {
                name.append(" " + parameters[i]);
            }

            day = Integer.parseInt(parameters[parameters.length - 3]);
            month = Integer.parseInt(parameters[parameters.length - 2]);
            year = Integer.parseInt(parameters[parameters.length - 1]);

            Date birthDay = new Date(year, month - 1, day);
            Person person = new Person(name.toString(), birthDay);
            PEOPLE.add(person);
        }

        fileRd.close();
    }

}
