package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Date initialDate;
        initialDate = inputDate();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        System.out.println(sdf.format(initialDate).toUpperCase());
    }

    private static Date inputDate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sDate = reader.readLine();
        Date date = new Date();
        String day = "";
        String month = "";
        String year = "";


        char[] cDate = sDate.toCharArray();

        for (int i = 0; i < cDate.length; i++) {
            if (i < 2) {
                month += cDate[i];
            } else if (i < 5 && i > 2) {
                day += cDate[i];
            } else if (i > 5){
                year += cDate[i];
            }
        }

        date.setDate(Integer.valueOf(day));
        date.setMonth(Integer.valueOf(month) - 1);
        date.setYear(Integer.parseInt(year) - 1900);

        return date;
    }
}
