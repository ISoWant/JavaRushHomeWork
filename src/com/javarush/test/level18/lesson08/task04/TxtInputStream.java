package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream fIS;
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);
        char[] chars = fileName.toCharArray();
        int size = chars.length - 1;
        String check = "" + chars[size - 3] + chars[size - 2] + chars[size - 1] + chars[size];
        if (check.equals(".txt"))
            fIS = new FileInputStream(fileName);
        else
            throw new UnsupportedFileNameException();
    }
}

