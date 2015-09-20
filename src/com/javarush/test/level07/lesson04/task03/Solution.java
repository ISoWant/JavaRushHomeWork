package com.javarush.test.level07.lesson04.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2 массива
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
5. Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] sArray = new String[10];
        int[] nArray = new int[10];

        scanArray(sArray);
        lengthStringToNArray(sArray, nArray);

        for (int position = 0; position < nArray.length; position++)
        {
            System.out.println(nArray[position]);
        }

    }

    public static void lengthStringToNArray(String[] sArray, int[] nArray)
    {
        for (int position = 0; position < sArray.length; position++)
        {
            nArray[position] = sArray[position].length();
        }
    }

    public static void scanArray(String[] sArray) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int position = 0; position < sArray.length; position++)
        {
            sArray[position] = reader.readLine();
        }
    }
}
