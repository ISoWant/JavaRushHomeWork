package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value != null) {
                result.append(" and ");
                result.append(key);
                result.append(" = ");
                result.append("\'" + value + "\'");
            }
        }

        if (result.length() > 0)
            result.replace(0, 5, "");

        return result;
    }

}
