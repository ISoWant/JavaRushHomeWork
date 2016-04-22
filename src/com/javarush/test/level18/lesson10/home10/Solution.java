package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        FileInputStream srcFile = null;
        Map<String, byte[]> parts = new TreeMap<>();

        while (!fileName.equals("end")) {
            srcFile = new FileInputStream(fileName);
            int size = srcFile.available();
            byte[] buffer = new byte[size];
            srcFile.read(buffer, 0, size);
            parts.put(fileName, buffer);

            fileName = rd.readLine();
        }
        rd.close();
        srcFile.close();

        for (String st : parts.keySet()) {
            char[] name = st.toCharArray();
            int count = 0;

            for (int i = name.length - 1; i > 0; i--) {
                if (name[i] != '.')
                    count++;
                else break;
            }

            fileName = "";
            for (int i = 0; i < name.length - (count + 1); i++) {
                fileName += name[i];
            }
            break;
        }
        FileOutputStream dstFile = new FileOutputStream(fileName);

        for (String st : parts.keySet()) {
            dstFile.write(parts.get(st));
        }

        dstFile.close();
    }
}
