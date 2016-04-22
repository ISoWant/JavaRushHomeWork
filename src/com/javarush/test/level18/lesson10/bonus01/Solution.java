package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    FileInputStream srcFile;
    FileOutputStream dstFile;

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        switch (args[0]) {
            case "-e":
                sol.encryption(args);
                break;
            case "-d":
                sol.decryption(args);
                break;
        }
    }

    private void decryption(String[] args) throws IOException {
        srcFile = new FileInputStream(args[1]);
        dstFile = new FileOutputStream(args[2]);

        if (srcFile.available() > 0) {
            int count = srcFile.read();

            Map<Integer, Integer> dictionary = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                int symbol = srcFile.read();
                int freak = srcFile.read();
                dictionary.put(freak, symbol);
            }

            while (srcFile.available() > 0) {
                Integer sm = srcFile.read();
                dstFile.write(dictionary.get(sm));
            }
        }
            srcFile.close();
            dstFile.close();
    }
/**
 * Способ шифрование такой:
 * первое значение которое я записываю в файл - сколько всего разных символов зашифрованно
 * Затем записываю поочерёдно все символы с числом
 * в формате sn, где s - исходный символ, а n - число, соответствующие частоте его использования
 * После чего записываю сам текст исходго файла заменяя все символы соответсвующим числом n
 * */
    private void encryption(String[] args) throws IOException {
        srcFile = new FileInputStream(args[1]);
        dstFile = new FileOutputStream(args[2]);

        Map<Integer, Integer> freak = new TreeMap<>();
        Map<Integer, Integer> dictionary = new TreeMap<>();
        int length = srcFile.available();
        byte[] buffer = new byte[length];
        srcFile.read(buffer, 0, length);

        for (int i = 0; i < buffer.length; i++) {
            int symbol = buffer[i];
            if (freak.containsKey(symbol)) {
                freak.put(symbol, freak.get(symbol) + 1);
            } else {
                freak.put(symbol, 1);
            }
        }

        for (int symbol : freak.keySet()) {
            int frequency = freak.get(symbol);
            while (dictionary.containsKey(frequency)) {
                frequency++;
            }
            dictionary.put(frequency, symbol);

        }

        dstFile.write(dictionary.size());

        int number = 0;
        for (int frequency : dictionary.keySet()) {
            int symbol = dictionary.get(frequency);
            dstFile.write(symbol);
            freak.put(symbol, number);
            dstFile.write(number++);
        }

        for (int i = 0; i < buffer.length; i++) {
            dstFile.write(freak.get((int) buffer[i]));
        }

        srcFile.close();
        dstFile.close();
    }

}
