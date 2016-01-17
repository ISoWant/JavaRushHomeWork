package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.valueOf(rd.readLine());
        int second = Integer.valueOf(rd.readLine());

        System.out.println(greatestCommonDivisor(first, second));
    }

    private static int greatestCommonDivisor(int first, int second) {
        int gCD = 1;

        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i < first; i++) {
            if (first % i == 0) {
                divisors.add(i);
            }
        }

        for (Integer divisor : divisors) {
            if (second % divisor == 0) {
                gCD = divisor;
            }
        }

        return gCD;
    }
}
