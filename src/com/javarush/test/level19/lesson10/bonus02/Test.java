package com.javarush.test.level19.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileConsoleWriter fw = new FileConsoleWriter(rd.readLine());
        int i = 99;
        fw.write(i);
        fw.close();
    }
}
