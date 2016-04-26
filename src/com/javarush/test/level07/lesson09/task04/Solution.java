package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква ?р? и буква ?л?
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву ?р?
2.2. удваивать все слова содержащие букву ?л?.
2.3. если слово содержит и букву ?р? и букву ?л?, то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        String s;
        System.out.println(list.size());

        for (int index = 0; index < list.size(); index++) {
            s = list.get(index);
            char[] charArray = s.toCharArray();
            int tmpr = 0, tmpl = 0;

            for (int character = 0; character < s.length(); character++) {
                if (charArray[character] == 'р' && tmpr == 0) {
                    tmpr++;
                } else if (charArray[character] == 'л' && tmpl == 0) {
                    tmpl++;
                }
            }
            if (tmpl < tmpr) {
                list.remove(index);
            }else if (tmpl > tmpr) {
                list.add(index, list.get(index));
                index++;
            }
        }
        return list;
    }
}