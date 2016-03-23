package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
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
        //start here - начни тут
    }

    private static void infoPerson(String[] args) {
        synchronized (allPeople) {
            for (int i = 1; i < args.length; i++) {
                int id = Integer.valueOf(args[i]);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(allPeople.get(id).getName() + " "
                        + (allPeople.get(id).getSex().equals(Sex.FEMALE)? "ж" : "м") + " "
                        + sdf.format(allPeople.get(id).getBirthDay()));
            }
        }
    }

    private static void deletePerson(String[] args) {
        synchronized (allPeople) {
            for (int i = args.length - 1; i > 0; i--) {
                int id = Integer.valueOf(args[i]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
        }
    }

    private static void updatePerson(String[] args) {
        int i = 1, id;
        while (i < args.length) {
            id = Integer.valueOf(args[i++]);
            String name = args[i++];

            while (!(args[i].equals("м")) && !(args[i].equals("ж"))) {
                name = name + " " + args[i++];
            }

            Date birthDay = formatDate(args[++i]);

            synchronized (allPeople) {
                allPeople.get(id).setName(name);
                allPeople.get(id).setSex(args[i - 1].equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(id).setBirthDay(birthDay);
            }
            i++;
        }
    }

    private static void createPerson(String[] args) {
        int i = 1;
        while(i < args.length) {
            String name = args[i++];

            while (!(args[i].equals("м")) && !(args[i].equals("ж"))) {
                name = name + " " + args[i++];
            }

            Date birthDay = formatDate(args[++i]);

            synchronized (allPeople) {
                if (args[i - 1].equals("м")) {
                    allPeople.add(Person.createMale(name, birthDay));
                } else if (args[i - 1].equals("ж")) {
                    allPeople.add(Person.createFemale(name, birthDay));
                }

                System.out.println(allPeople.size() - 1);
            }
            i++;

        }
    }

    private static Date formatDate(String arg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDay = new Date();
        try {
             birthDay = sdf.parse(arg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthDay;
    }
}
