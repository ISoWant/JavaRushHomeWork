package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                createPerson(args);
                break;
            case "-u":
                updatePerson(args);
                break;
            case "-d":
                deletePerson(args);
                break;
            case "-i":
                infoPerson(args);
                break;
        }
    }

    private static void infoPerson(String[] args) {
        int id = Integer.valueOf(args[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(allPeople.get(id).getName() + " "
                + (allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж") + " "
                + sdf.format(allPeople.get(id).getBirthDay()));
    }

    private static void deletePerson(String[] args) {
        int id = Integer.valueOf(args[1]);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    private static void updatePerson(String[] args) {
        int id = Integer.valueOf(args[1]);
        allPeople.get(id).setName(args[2]);
        allPeople.get(id).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
        Date birthDay = getBirthDay(args[4]);
        allPeople.get(id).setBirthDay(birthDay);
    }

    private static void createPerson(String[] args) {
        String name = args[1];
        int i = 2;
        while (!(args[i].equals("м")) && !(args[i].equals("ж"))) {
            name = name + " " + args[i];
            i++;
        }

        Date birthDay = getBirthDay(args[i + 1]);


        if (args[i].equals("м")) {
            allPeople.add(Person.createMale(args[1], birthDay));
        } else if (args[i].equals("ж")) {
            allPeople.add(Person.createFemale(args[1], birthDay));
        }
        System.out.println(allPeople.size() - 1);
    }

    private static Date getBirthDay(String arg) {
        Date birthDay = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            birthDay = sdf.parse(arg);
        } catch (ParseException e) {
        }

        return birthDay;
    }
}
