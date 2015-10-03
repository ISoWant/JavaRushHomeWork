package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[20];

        for (int index = 0; index < 20; index++) {
            array[index] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        int newElem;
        for (int barrier = 0; barrier < array.length; barrier++) {
            for (int index = 0; index < array.length - 1 - barrier; index++) {
                newElem = array[index];

                if (newElem < array[index + 1]) {
                    array[index] = array[index + 1];
                    array[index + 1] = newElem;
                }

            }
        }
    }
}
