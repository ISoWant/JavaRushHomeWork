package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> numbers = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            numbers.add(reader.readLine());
        }

        for (int index = 0; index < M; index++) {
            numbers.add(N, numbers.get(0));
            numbers.remove(0);
        }

        for (int index = 0; index < numbers.size(); index++) {
            System.out.println(numbers.get(index));
        }
    }
}
