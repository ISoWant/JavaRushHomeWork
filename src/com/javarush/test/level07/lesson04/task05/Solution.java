package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.test.level07.lesson04.task05.Solution.scanArray;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] bigArray = new int[20];
        int[] smallArray = new int[10];
        int[] resultArray = new int[10];

        scanArray(bigArray);//Вводим с клавиатуры массив на 20 чисел


        System.arraycopy(bigArray, 0, smallArray, 0, smallArray.length);
        System.arraycopy(bigArray, bigArray.length - smallArray.length, resultArray, 0, resultArray.length);
        //copyArray(bigArray, smallArray, 0);
        //copyArray(bigArray, resultArray, 10);

        for (int column = 0; column < resultArray.length; column++)
        {
            System.out.println(resultArray[column]);
        }

    }

    /*public static void copyArray(int[] srcArray, int[] destArray, int beginning)
    {
        for (int position = 0, column = beginning; position < destArray.length; position++, column++)
        {
            destArray[position] = srcArray[column];
        }

    }*/

    public static void scanArray(int[] array) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String element;

        for (int column = 0; column < array.length; column++)
        {
            element = reader.readLine();
            array[column] = Integer.parseInt(element);
        }
    }

}
