package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу:
«фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {

    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Me", new Date("OCTOBER 23 1992"));
        map.put("Evstifeev", new Date("AUGUST 13 1991"));
        map.put("NewPeople", new Date("DECEMBER 1 2013"));
        map.put("OldMan", new Date("JULY 30 1899"));
        map.put("Christ", new Date("JANUARY 7 0001"));
        map.put("Mountaineer", new Date("JUNE 17 1752"));
        map.put("StreetRacer", new Date("SEPTEMBER 1 1990"));
        map.put("Perez", new Date("MAY 1 2015"));
        map.put("Santa", new Date("JUNE 1 1090"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date month = pair.getValue();
            if (month.getMonth() > 4 && month.getMonth() < 8) iterator.remove();
        }
    }
}
