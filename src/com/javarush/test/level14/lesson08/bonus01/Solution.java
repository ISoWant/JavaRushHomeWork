package com.javarush.test.level14.lesson08.bonus01;

import sun.dc.path.PathException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            exceptions.add(e);
        }

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            throw new IOException();
        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            throw new PathException();
        } catch (PathException e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            exceptions.add(e);
        }

        try {
            throw new StringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            exceptions.add(e);
        }

        try {
            throw new NegativeArraySizeException();
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        //Add your code here

    }
}
