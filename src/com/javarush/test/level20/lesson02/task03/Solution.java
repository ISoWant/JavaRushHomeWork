package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        FileInputStream file;
        Solution thisSolution = new Solution();
        try {
            fileName = rd.readLine();
            file = new FileInputStream(fileName);
            thisSolution.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (String key : properties.keySet()) {
            prop.setProperty(key, properties.get(key));
            System.out.println(key);
        }
        prop.store(outputStream, "");


        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration enumeration = prop.keys();
        String key;

        while (enumeration.hasMoreElements()) {
            key = enumeration.nextElement().toString();
            properties.put(key, prop.getProperty(key));
        }

        inputStream.close();
        //implement this method - реализуйте этот метод
    }
}
