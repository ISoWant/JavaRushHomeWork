package com.javarush.test.level08.lesson04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class NumberDay {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Пожалуста, введити дату вашего рождения(dd.mm.yyyy): ");
        String birthDay = reader.readLine();

        System.out.print("Ваш пол?(м/ж): ");
        String sSex = reader.readLine();
        boolean sex;
        if (sSex.equals("м")) {
            sex = true;
        } else {
            sex = false;
        }

        Date lifeStartTime = new Date();
        setDate(lifeStartTime, birthDay, 0);

        Date currentTime = new Date();
        int dayCount = setCountDay(currentTime, lifeStartTime);

        System.out.println("Итак, твоё появление на свет произошло " + birthDay + ". А это означает, что:");
        System.out.println("С момента твоего рождения уже прошло " + dayCount + " дней.");

        Date averageLifeExpectancy = new Date();

        int averageLife = sex ? 63 : 75;

        setDate(averageLifeExpectancy, birthDay, averageLife);

        int allDayCount = setCountDay(averageLifeExpectancy, lifeStartTime);

        System.out.println("Если ориентироваться на среднюю продолжительность жизни в России, то ");
        System.out.printf("тобою уже прожито %3.2f", ((float)dayCount/(float)allDayCount) * 100.0);
        System.out.println("% от твоей жизни");
    }

    private static int setCountDay(Date decreaseTime, Date subtractedTime) {
        long msInADay = 86400000;

        long msTimeDistance = decreaseTime.getTime() - subtractedTime.getTime();

        return (int) (msTimeDistance / msInADay);
    }

    private static void setDate(Date date, String day, int year) {
        char[] days = day.toCharArray();
        int j = 0;
        String sDay = "";
        String sMonth = "";
        String sYear = "";

        for (int i = 0; i < days.length; i++) {
            if (j == 0) {
                if (days[i] != '.') sDay += days[i];
                else j++;
            } else if (j == 1) {
                if (days[i] != '.') sMonth += days[i];
                else j++;
            } else {
                sYear += days[i];
            }
            }

        int nDay = Integer.parseInt(sDay);
        int nMonth = Integer.parseInt(sMonth);
        int nYear = Integer.parseInt(sYear);

        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);

        date.setDate(nDay);
        date.setMonth(nMonth - 1);
        date.setYear(nYear - 1900 + year);
    }
}
