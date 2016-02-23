package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));//напиште тут ваш код
        String st = rd.readLine();

        int intValue;
        short shortValue;
        Double doubleValue;
        ArrayList<Object> data = new ArrayList<Object>();

        while (!(st.equals("exit"))) {
            try {
                if (st.indexOf(".") < 0) {
                    intValue = Integer.valueOf(st);
                    if (intValue < 128) {
                        shortValue = (short) intValue;
                        data.add(shortValue);
                    } else {
                        data.add(intValue);
                    }
                } else {
                    doubleValue = Double.valueOf(st);
                    data.add(doubleValue);
                }

            } catch (NumberFormatException e) {
                data.add(st);
            }

            st = rd.readLine();
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) instanceof String) {
                print((String) data.get(i));
            } else if (data.get(i) instanceof Double) {
                print((Double) data.get(i));
            } else if (data.get(i) instanceof Integer) {
                print((Integer) data.get(i));
            } else print((Short)data.get(i));
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
