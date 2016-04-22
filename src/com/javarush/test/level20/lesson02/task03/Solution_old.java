package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution_old {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Solution_old s = new Solution_old();
        s.fillInPropertiesMap();

        for (String s1 : properties.keySet()) {
            System.out.println(s1 + "=" + properties.get(s1));
        }

    }

    public void fillInPropertiesMap() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        rd.close();

        Pattern pattern = Pattern.compile("^[\\w_а-яА-Я_\\._\\\\]+(:|\\s|=)");

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();

        while (fileRd.ready()) {
            String line = fileRd.readLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                key.append(matcher.group());
                line = line.substring(matcher.group().length());
                if (matcher.group().endsWith("\\ ")) {
                    matcher = pattern.matcher(line);
                } else {
                    break;
                }
            }

            if (key.length() > 0) {
                value.append(line);
                while (line.startsWith(":") || line.startsWith(" ") || line.startsWith("=")) {
                    value.delete(0, 1);
                    line = value.toString();
                }
                while (line.endsWith("\\") && fileRd.ready()) {
                    line = fileRd.readLine();
                    value.append(line);
                }
                key.delete(key.length() - 1, key.length());
                properties.put(key.toString(), value.toString());
                key.delete(0, key.length());
                value.delete(0, value.length());
            }
        }

        fileRd.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }
}
