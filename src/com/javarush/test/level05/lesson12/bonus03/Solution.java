package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String scount = reader.readLine();
        int count = Integer.parseInt(scount);

        while (count <= 0)
        {
            scount = reader.readLine();
            count = Integer.parseInt(scount);
        }

        int array1[] = new int[count];
        int i = 0;

        while (i < count)
        {
            scount = reader.readLine();
            array1[i] = Integer.parseInt(scount);

            i++;
        }

        int maximum = array1[0];

        for (i = 0; i < count; i++)
        {
            if (array1[i] > maximum)
                maximum = array1[i];
        }

        System.out.println(maximum);
    }
}
