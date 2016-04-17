package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {
    private FileWriter fileWr;

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
        fileWr = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
        fileWr = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
        fileWr = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
        fileWr = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
        fileWr = new FileWriter(fd);
    }


    @Override
    public void write(int c) throws IOException {
        fileWr.write(c);
        System.out.println((char) c);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        fileWr.write(cbuf);
        System.out.println(new String(cbuf));
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        fileWr.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWr.write(cbuf, off, len);
        System.out.println(new String(cbuf, off, len));
    }

    @Override
    public void write(String str) throws IOException {
        fileWr.write(str);
        System.out.println(str);
    }

    @Override
    public void close() throws IOException {
        fileWr.close();
    }
}
