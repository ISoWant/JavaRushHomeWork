package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        Random rand = new Random();
        String s = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя ,.";
        char[] array = s.toCharArray();

        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String>[] listListov = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String st = "";
                for (int k = 0; k < 20; k++) {
                    st += array[rand.nextInt(36)];
                }
                strings.add(st);
            }
            listListov[i] = strings;
        }

        //напишите тут ваш код
        return listListov;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}