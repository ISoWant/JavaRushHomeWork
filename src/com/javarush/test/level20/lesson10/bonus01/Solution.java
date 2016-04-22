package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M цифр, например, S = 370 и M(количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int[] result = null;
       // result = getArmstrong(N);
        return result;
    }

    private static void getArmstrong(int n) {
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = 0;
        ArrayList<Integer> armstrongNumers = new ArrayList<>();

        while (n != 0) {
            length++;
            n /= 10;
        }

        /*for (int i = 2; i < length; i++) {
            for (int j = 0; j < ; j++) {

            }
        }*/

    }
}

