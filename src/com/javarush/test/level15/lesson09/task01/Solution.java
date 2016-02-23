package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.0, "five");
        labels.put(7.0, "seven");
        labels.put(6.0, "six");
        labels.put(4.0, "four");
        labels.put(9.0, "others");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
