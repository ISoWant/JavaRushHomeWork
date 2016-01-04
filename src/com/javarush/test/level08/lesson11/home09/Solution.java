package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

import java.util.Date;


public class Solution {

    public static void main(String[] args) {
        Date date = new Date();
        String requiredFormat = "FEBRUARY 5 2013";
        boolean parity;

        parity = isDateOdd(requiredFormat);

        System.out.println(requiredFormat + " = " + parity);
    }

    public static boolean isDateOdd(String date) {
        char year[] = date.toCharArray();
        String sYear = "";
        String sMounth = "";
        String sDay = "";

        boolean result;

        Date startOfYear = new Date();
        Date adjustedDate = new Date();

        int nDay;
        int nMonth = 0;
        int nYear;
        int j = 0;

        long parity;

        for (int i = year.length - 4; i < year.length; i++) {
            sYear += year[i];
        }

        nYear = Integer.parseInt(sYear);

        startOfYear.setDate(0);
        startOfYear.setMonth(0);
        startOfYear.setYear(nYear);

        while (year[j] != ' ') {
            sMounth += year[j++];
        }

        j++;

        while (year[j] != ' ') {
            sDay += year[j++];
        }

        nDay = Integer.valueOf(sDay);

        if (sMounth.equals("JANUARY")) {
            nMonth = 0;
        } else if (sMounth.equals("FEBRUARY")) {
            nMonth = 1;
        } else if (sMounth.equals("MARCH")) {
            nMonth = 2;
        } else if (sMounth.equals("APRIL")) {
            nMonth = 3;
        } else if (sMounth.equals("MAY")) {
            nMonth = 4;
        } else if (sMounth.equals("JUNE")) {
            nMonth = 5;
        } else if (sMounth.equals("JULY")) {
            nMonth = 6;
        } else if (sMounth.equals("AUGUST")) {
            nMonth = 7;
        } else if (sMounth.equals("SEPTEMBER")) {
            nMonth = 8;
        } else if (sMounth.equals("OCTOBER")) {
            nMonth = 9;
        } else if (sMounth.equals("NOVEMBER")) {
            nMonth = 10;
        } else if (sMounth.equals("DECEMBER")) {
            nMonth = 11;
        }

        adjustedDate.setDate(nDay);
        adjustedDate.setMonth(nMonth);
        adjustedDate.setYear(nYear);

        parity = startOfYear.getTime() - adjustedDate.getTime();

        if ((parity / (24 * 60 * 60 * 1000)) % 2 != 0) {
            result = true;
        }
        else result = false;

        return result;
    }
}
