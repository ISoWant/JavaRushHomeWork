package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Human> grandchild = new ArrayList<Human>();
        ArrayList<Human> children = new ArrayList<Human>();

        Human child1 = new Human("Jenny", false, 16, grandchild);
        Human child2 = new Human("Mark", true, 19, grandchild);
        Human child3 = new Human("Veronika", false, 13, grandchild);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        grandchild.add(child1);
        grandchild.add(child2);
        grandchild.add(child3);

        Human dad = new Human("Anton", true, 44, grandchild);
        Human mum = new Human("Anastasia", false, 39, grandchild);
        System.out.println(mum);
        System.out.println(dad);

        children.add(dad);

        Human grandpaDad = new Human("Sergey", true, 65, children);
        Human grandmumDad = new Human("Lydmila", false, 63, children);
        System.out.println(grandpaDad);
        System.out.println(grandmumDad);

        children.remove(dad);
        children.add(mum);

        Human grandpaMum = new Human("Alexandr", true, 64, children);
        Human grandmumMum = new Human("Elena", false, 60, children);

        System.out.println(grandpaMum);
        System.out.println(grandmumMum);
        //напишите тут ваш код
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        //напишите тут ваш код

        @Override
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
