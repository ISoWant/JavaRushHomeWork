package com.javarush.test.level08.lesson08.task03;

/*Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу
«Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> fio = new HashMap<String, String>();

        fio.put("Евстифеев", "Антон");
        fio.put("Брат", "Андрей");
        fio.put("Шпаков", "Андрей");
        fio.put("Дёрдан", "Тайлер");
        fio.put("Муди", "Хэнк");
        fio.put("Тагерт", "Дагни");
        fio.put("Белучи", "Моника");
        fio.put("Альба", "Джессика");
        fio.put("Йохансан", "Скарлет");
        fio.put("Орейра", "Натлия");

        return fio;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int i = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String mName = pair.getValue();
            if (name.equals(mName)) i++;
        }

        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya) {
        int i = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String lName = pair.getKey();
            if (familiya.equals(lName)) i++;
        }

        return i;
    }
}