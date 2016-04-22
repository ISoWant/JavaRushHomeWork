package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    final private int LengthOfID = 8;
    final private int LengthOfProductName = 30;
    final private int LengthOfPrice = 8;
    final private int LengthOfQuantity = 4;
    private String fileName;

    public static void main(String[] args) throws IOException {
        Solution task = new Solution();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        task.fileName = rd.readLine();
        rd.close();

        switch (args[0]) {
            case "-u":
                task.updateProduct(args);
                break;
            case "-d":
                task.deleteProduct(args[1]);
                break;
        }
    }

    private void updateProduct(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        ArrayList<String> buffer = new ArrayList<>();
        String product;
        String id = addSpaces(args[1], LengthOfID);
        String productName = addSpaces(args[2], LengthOfProductName);
        String price = addSpaces(args[3], LengthOfPrice);
        String quantity = addSpaces(args[4], LengthOfQuantity);

        while ((product = fileRd.readLine()) != null) {
            if (product.startsWith(id)) {
                buffer.add(id + productName + price + quantity);
            } else {
                buffer.add(product);
            }
        }

        fileRd.close();
        filing(buffer);
    }

    private void filing(ArrayList<String> buffer) throws IOException {
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(fileName));

        for (String position : buffer) {
            fileWr.write(position + '\n');
        }

        fileWr.close();
    }

    private String addSpaces(String parameter, int length) {
        StringBuilder result = new StringBuilder(parameter);
        while (result.length() < length) {
            result.append(' ');
        }
        return result.toString();
    }

    private void deleteProduct(String id) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        String product;
        ArrayList<String> buffer = new ArrayList<>();

        while ((product = fileRd.readLine()) != null) {
            if (!product.startsWith(id)) {
                buffer.add(product);
            }
        }
        fileRd.close();
        filing(buffer);
    }
}