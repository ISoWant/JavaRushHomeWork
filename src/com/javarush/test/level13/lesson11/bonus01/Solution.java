package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        TreeSet<Integer> array = fromFile();

        clean(array);

        for (Integer integer : array) {
            System.out.println(integer);
        }

        // напишите тут ваш код
    }

    private static TreeSet<Integer> fromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream file = new FileInputStream(reader.readLine());

        TreeSet <Integer> array = new TreeSet<Integer>();
        char c;
        String st = "";


        while (file.available() > 0) {
            c = (char)file.read();
            if (isNumber(c)) {
                st = st + c;
            } else if (st != ""){
                array.add(Integer.valueOf(st));
                st = "";
            }
            if (file.available() == 0){
                array.add(Integer.valueOf(st));
                st = "";
            }
        }

        return array;
    }

    private static boolean isNumber(char c) {
        boolean verity = false;
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        for (int i = 0; i < numbers.length; i++) {
            if (c == numbers[i]) {
                verity = true;
            }
        }

        return verity;
    }

    private static void clean(TreeSet<Integer> array) {
        Iterator<Integer> it = array.iterator();

        while (it.hasNext()) {
            if (it.next() % 2 != 0) {
                it.remove();
            }
        }
    }
}
