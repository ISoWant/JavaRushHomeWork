package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream("JavaRush.txt");
            InputStream inputStream = new FileInputStream("JavaRush.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Anton");
            user.setLastName("Evstifeev");
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            Calendar calendar = new GregorianCalendar(1992, 9, 23);
            Date birthDay = calendar.getTime();
            user.setBirthDate(birthDay);
            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("Andrey");
            user1.setLastName("Evstifeev");
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);
            calendar = new GregorianCalendar(2007, 7, 13);
            birthDay = calendar.getTime();
            user1.setBirthDate(birthDay);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Andrey");
            user2.setLastName("Shpakov");
            user2.setCountry(User.Country.RUSSIA);
            user2.setMale(true);
            calendar = new GregorianCalendar(1993, 8, 6);
            birthDay = calendar.getTime();
            user2.setBirthDate(birthDay);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            for (User us : loadedObject.users) {
                System.out.println(us.getFirstName());
                System.out.println(us.getLastName());
                System.out.println(us.getBirthDate());
                System.out.println(us.getCountry());
                System.out.println(us.isMale());
            }

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write("This is new JavaRush object\n".getBytes());
            for (User user : users) {
                outputStream.write((user.getFirstName() + "\n").getBytes());
                outputStream.write((user.getLastName() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getDate() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getMonth() + "\n").getBytes());
                outputStream.write((user.getBirthDate().getYear() + "\n").getBytes());
                outputStream.write(((user.isMale() + "").toString() + "\n").getBytes());
                outputStream.write((user.getCountry().toString() + "\n").getBytes());
            }

            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            String isJavaRush = "This is new JavaRush object";
            StringBuilder line = new StringBuilder();
            char c = (char) inputStream.read();

            while (c != '\n') {
                c = (char) inputStream.read();
            }

            line.append(readParam(inputStream));

            while (!line.equals(isJavaRush) && inputStream.available() != 0) {
                User user = new User();
                user.setFirstName(line.toString());
                user.setLastName(readParam(inputStream));
                int day = Integer.parseInt(readParam(inputStream));
                int month = Integer.parseInt(readParam(inputStream));
                int year = 1900 + Integer.parseInt(readParam(inputStream));
                Calendar calendar = new GregorianCalendar(year, month, day);
                user.setBirthDate(calendar.getTime());
                user.setMale(readParam(inputStream).equals("true"));
                String country = readParam(inputStream);
                if (country.equals("RUSSIA")) {
                    user.setCountry(User.Country.RUSSIA);
                } else if (country.equals("UKRAINE")) {
                    user.setCountry(User.Country.UKRAINE);
                } else {
                    user.setCountry(User.Country.OTHER);
                }
                this.users.add(user);
                line.delete(0, line.length());
                line.append(readParam(inputStream));
            }
            //implement this method - реализуйте этот метод
        }

        private String readParam(InputStream inputStream) throws IOException {
            StringBuilder line = new StringBuilder();
            char c = (char) inputStream.read();
            while (c != '\n' && inputStream.available() != 0) {
                line.append(c);
                c = (char) inputStream.read();
            }

            return line.toString();
        }
    }
}
