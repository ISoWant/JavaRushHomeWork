package com.javarush.test.level07.lesson04.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] sArray = new String[10];

        scanArray(sArray);

        for (int position = 0; position < sArray.length; position++)
        {
            System.out.println(sArray[(sArray.length - 1) - position]);
        }

    }

    public static void scanArray(String[] sArray) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int position = 0; position < 8; position++)
        {
            sArray[position] = reader.readLine();
        }
    }
}