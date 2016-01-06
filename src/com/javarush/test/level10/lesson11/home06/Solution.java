package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class Human {
        public String name;
        public String surname;
        public String patronymic;
        public int age;
        private int waight;
        private int growth;

        public Human() {
            name = "incognita";
            surname = "incognita";
            patronymic = "incognita";
            age = 0;
            waight = 0;
            growth = 0;
        }

        public Human(String name) {
            this.name = name;
            surname = "incognita";
            patronymic = "incognita";
            age = 0;
            waight = 0;
            growth = 0;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
            patronymic = "incognita";
            age = 0;
            waight = 0;
            growth = 0;
        }

        public Human(String name, String surname, String patronymic) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            age = 0;
            waight = 0;
            growth = 0;
        }

        public Human(int age) {
            name = "incognita";
            surname = "incognita";
            patronymic = "incognita";
            this.age = age;
            waight = 0;
            growth = 0;
        }

        public Human(int waight, int growth) {
            name = "incognita";
            surname = "incognita";
            patronymic = "incognita";
            age = 0;
            this.waight = waight;
            this.growth = growth;
        }

        public Human(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            patronymic = "incognita";
            this.age = age;
            waight = 0;
            growth = 0;
        }

        public Human(String name, String surname, String patronymic, int age) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.age = age;
            waight = 0;
            growth = 0;
        }

        public Human(String name, String surname, int age, int waight) {
            this.name = name;
            this.surname = surname;
            patronymic = "incognita";
            this.age = age;
            this.waight = waight;
            growth = 0;
        }

        public Human(String name, String surname, String patronymic, int age, int waight, int growth) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.age = age;
            this.waight = waight;
            this.growth = growth;
        }
        //напишите тут ваши переменные и конструкторы
    }
}
