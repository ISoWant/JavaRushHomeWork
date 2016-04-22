package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name = rd.readLine();

        while (!name.equals("exit")) {
            new ReadThread(name);
            name = rd.readLine();
        }

        rd.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            this.run();
            //implement constructor body
        }

        @Override
        public void run() {
            Map<Integer, Integer> counts = new HashMap<>();
            FileInputStream file = null;
            try {
                 file = new FileInputStream(fileName);
                int counter = 0, key = 0;

                while (file.available() > 0) {
                    int symbol = file.read();
                    if (counts.containsKey(symbol)) {
                        counts.put(symbol, counts.get(symbol) + 1);
                    } else counts.put(symbol, 1);
                }

                for (Integer next : counts.keySet()) {
                    if (counter < counts.get(next)) {
                        counter = counts.get(next);
                        key = next;
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, key);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
