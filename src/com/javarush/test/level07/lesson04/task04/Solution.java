package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = new int[10];

        scanArray(array);

        reverseArray(array);

        for (int position = 0; position < array.length; position++)
        {
            System.out.println(array[position]);
        }
        //напишите тут ваш код

    }

    public static void reverseArray(int[] array)
    {
        int tmp;

        for (int position = 0; position < array.length/2; position++)
        {
            tmp = array[position];
            array[position] = array[(array.length - 1) - position];
            array[(array.length - 1) - position] = tmp;
        }
    }

    public static void scanArray(int[] array) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String element;

        for (int position = 0; position < array.length; position++)
        {
            element = reader.readLine();
            array[position] = Integer.parseInt(element);
        }
    }
}
