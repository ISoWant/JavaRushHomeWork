package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution {
    public static void main(String[] args) {
        Human grandpaF = new Human();
        grandpaF.name = "Роберт";
        grandpaF.sex = true;
        grandpaF.age = 75;
        System.out.println(grandpaF);

        Human grandpaM = new Human();
        grandpaM.name = "Иван Фёдорович";
        grandpaM.sex = true;
        grandpaM.age = 80;
        System.out.println(grandpaM);

        Human nanF = new Human();
        nanF.name = "Вероника";
        nanF.sex = false;
        nanF.age = 56;
        System.out.println(nanF);

        Human nanM = new Human();
        nanM.name = "Елена";
        nanM.sex = false;
        nanM.age = 50;
        System.out.println(nanM);

        Human dad = new Human();
        dad.name = "Отец";
        dad.sex = true;
        dad.age = 38;
        dad.father = grandpaF;
        dad.mother = nanF;
        System.out.println(dad);

        Human ma = new Human();
        ma.name = "Катюша";
        ma.sex = false;
        ma.age = 30;
        ma.father = grandpaM;
        ma.mother = nanM;
        System.out.println(ma);

        Human son = new Human();
        son.name = "Майк";
        son.sex = true;
        son.age = 5;
        son.father = dad;
        son.mother = ma;
        System.out.println(son);

        Human daughter = new Human();
        daughter.name = "Ангелина";
        daughter.sex = false;
        daughter.age = 3;
        daughter.father = dad;
        daughter.mother = ma;
        System.out.println(daughter);

        Human yangerSon = new Human();
        yangerSon.name = "Малой";
        yangerSon.sex = true;
        yangerSon.age = 3;
        yangerSon.father = dad;
        yangerSon.mother = ma;
        System.out.println(yangerSon);


    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
