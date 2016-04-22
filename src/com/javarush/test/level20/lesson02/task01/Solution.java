package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream("human.txt");
            InputStream inputStream = new FileInputStream("human.txt");
            Asset moto = new Asset("moto");
            moto.setPrice(3.33);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"), moto);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            for (Asset asset : somePerson.assets) {
                System.out.println(asset.getName() + " : " + asset.getPrice());
            }

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write(this.name.getBytes());
            outputStream.write('\n');

            for (Asset asset : assets) {

                if (asset.getName() != null) {
                    outputStream.write(asset.getName().getBytes());
                } else {
                    outputStream.write("".getBytes());
                }
                outputStream.write('\n');


                outputStream.write((asset.getPrice() + "").getBytes());
                outputStream.write('\n');
            }

            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            char c = (char) inputStream.read();
            String name = "";
            String assetName = "";
            String assetPrice = "";

            while (c != '\n') {
                name += c;
                c = (char) inputStream.read();
            }
            this.name = name;

            while (inputStream.available() != 0) {
                c = (char) inputStream.read();
                while (c != '\n') {
                    assetName += c;
                    c = (char) inputStream.read();
                }

                c = (char) inputStream.read();
                while (c != '\n') {
                    assetPrice += c;
                    c = (char) inputStream.read();
                }

                Asset asset = new Asset(assetName);
                asset.setPrice(Double.parseDouble(assetPrice));

                this.assets.add(asset);
                assetName = "";
                assetPrice = "";
            }
            //implement this method - реализуйте этот метод
        }
    }
}
