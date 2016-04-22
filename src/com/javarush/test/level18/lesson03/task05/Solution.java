package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream file = new FileInputStream(fileName);
        TreeSet<Integer> set = new TreeSet<>();
        Integer current;

        while (file.available() > 0) {
            current = file.read();
            set.add(current);
        }

        Iterator<Integer> it = set.iterator();
        StringBuilder sb = new StringBuilder();

        for (;;) {
            Integer e = it.next();
            sb.append(e);
            if (! it.hasNext()) break;
            sb.append(' ');
        }

        System.out.println(sb);

        rd.close();
        file.close();
    }
}
