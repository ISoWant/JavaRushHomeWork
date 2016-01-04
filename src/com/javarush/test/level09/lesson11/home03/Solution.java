package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = new ArrayList<Integer>();

        try {
            while (true) {
                String sNumber = reader.readLine();
                array.add(Integer.valueOf(sNumber));
            }
        } catch (Exception e) {
            for (int i = 0; i < array.size(); i++) {
                System.out.println(array.get(i));
            }
        }

        //напишите тут ваш код
    }
}
