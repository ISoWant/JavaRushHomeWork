package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("file.tmp", null);
        File fileWr = new File("E:\\IdeaProjects\\JavaRushHomeWork\\src\\com\\javarush\\" +
                "test\\level20\\lesson10\\home07\\Checker.txt");
        Solution solution = new Solution(fileWr.getPath());
        solution.writeObject("Приветствие!");
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileOut);
        oos.writeObject(solution);
        oos.close();
        fileOut.close();
        solution.stream.close();

        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileIn);
        Solution sol = (Solution) ois.readObject();
        sol.writeObject("Прощание!");
        ois.close();
        fileIn.close();

    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
