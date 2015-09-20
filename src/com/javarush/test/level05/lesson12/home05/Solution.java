package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean truth;
        int i = 0, nSum;
        String sSum;

        do
        {
            sSum = br.readLine();
            truth = sSum.equals("сумма");

            if(truth)
                System.out.println(i);
            else
            {
                nSum = Integer.parseInt(sSum);
                i += nSum;
            }

        }while (!truth);

        //напишите тут ваш код
    }
}
