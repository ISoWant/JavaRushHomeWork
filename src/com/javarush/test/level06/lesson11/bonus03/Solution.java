package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[5];
        String elem;

        for (int index = 0; index < array.length; index++)
        {
            elem = reader.readLine();
            array[index] = Integer.parseInt(elem);
        }

        insertionSort(array);

        for (int index = 0; index < array.length; index++)
        {
            System.out.println(array[index]);
        }
    }

    private static void insertionSort(int[] array)
    {
        int newElem;
        int tmp;

        for (int barrier = 1; barrier < array.length; barrier++)
        {
            newElem = array[barrier];

            if (newElem < array[barrier - 1])
            {
                tmp = Arrays.binarySearch(array, 0, barrier - 1, newElem);

                if (tmp < 0)
                {
                    tmp = (-tmp) - 1;
                }
                System.arraycopy(array, tmp, array, tmp + 1, barrier - tmp);
                array[tmp] = newElem;
            }

        }
    }
}
