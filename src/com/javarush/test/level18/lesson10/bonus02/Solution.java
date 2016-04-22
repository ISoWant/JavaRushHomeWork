package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    final private int LengthOfID = 8;
    final private int LengthOfProductName = 30;
    final private int LengthOfPrice = 8;
    final private int LengthOfQuantity = 4;

    public static void main(String[] args) throws IOException {
        Solution task = new Solution();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd.close();

        if (args[0].equals("-c")) {
            int id = task.readData(fileName);
            task.writePosition(fileName, args, id);
        }
    }

    private int readData(String fileName) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(fileName));
        String product, sID;
        int counter, id, maxID = 0;
        char[] symbols;

        while ((product = fileRd.readLine()) != null) {
            symbols = product.toCharArray();
            counter = 0;
            sID = "";

            while (symbols[counter] != ' ' && counter < 8) {
                sID = sID + symbols[counter];
                counter++;
            }

            id = Integer.valueOf(sID);
            if (id > maxID) {
                maxID = id;
            }
        }
        fileRd.close();
        return ++maxID;
    }

    private void writePosition(String fileName, String[] args, int id) throws IOException {
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(fileName, true));

        StringBuilder product = new StringBuilder();
        StringBuilder sbID = new StringBuilder();
        sbID.append(id);
        while (sbID.length() < LengthOfID) {
            sbID.append(' ');
        }

        StringBuilder sbProductName = new StringBuilder();
        sbProductName.append(args[1]);
        while (sbProductName.length() < LengthOfProductName) {
            sbProductName.append(' ');
        }

        StringBuilder sbPrice = new StringBuilder();
        sbPrice.append(args[2]);
        while (sbPrice.length() < LengthOfPrice) {
            sbPrice.append(' ');
        }

        StringBuilder sbQuantity = new StringBuilder();
        sbQuantity.append(args[3]);
        while (sbQuantity.length() < LengthOfQuantity) {
            sbQuantity.append(' ');
        }

        product.append(sbID);
        product.append(sbProductName);
        product.append(sbPrice);
        product.append(sbQuantity);

        fileWr.write(product.toString());


        fileWr.close();
    }
}
