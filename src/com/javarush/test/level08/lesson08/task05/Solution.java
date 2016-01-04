package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> fio = new HashMap<String, String>();

        fio.put("Фамилия", "Имя");
        fio.put("Евстифеев", "Антон");
        fio.put("Киану", "Ривз");
        fio.put("Малышева", "Елена");
        fio.put("Просто", "Сложный");
        fio.put("Несказанно", "Сказочный");
        fio.put("Персидский", "Румын");
        fio.put("Космос", "Амёбы");
        fio.put("Прекрасная", "Елена");
        fio.put("Альфа", "Омега");

        return fio;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        HashMap<String, String> copySecond = new HashMap<String, String>(map);
        String firstName;
        int i = 0;

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            firstName = pair.getValue();

            for (Map.Entry<String, String> pairSecond : copySecond.entrySet()) {
                if (pairSecond.getValue().equals(firstName)) {
                    if (i == 0) {
                        i = 1;
                    } else {
                        map.remove(pair.getKey());
                        map.remove(pairSecond.getKey());
                    }
                }
            }

            i = 0;
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        System.out.println(map);
    }
}
