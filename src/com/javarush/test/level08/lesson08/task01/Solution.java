package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {

    public static HashSet<String> createSet() {
        HashSet<String> newSet = new HashSet<String>();

        newSet.add("Любовь19");
        newSet.add("Любовь18");
        newSet.add("Любовь17");
        newSet.add("Любовь16");
        newSet.add("Любовь15");
        newSet.add("Любовь14");
        newSet.add("Любовь13");
        newSet.add("Любовь12");
        newSet.add("Любовь11");
        newSet.add("Любовь10");
        newSet.add("Любовь0");
        newSet.add("Любовь9");
        newSet.add("Любовь8");
        newSet.add("Любовь7");
        newSet.add("Любовь6");
        newSet.add("Любовь5");
        newSet.add("Любовь4");
        newSet.add("Любовь3");
        newSet.add("Любовь2");
        newSet.add("Любовь1");


        return newSet;
    }
}
