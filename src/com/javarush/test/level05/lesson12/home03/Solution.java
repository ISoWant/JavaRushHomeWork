package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat TomCat = new Cat("Tom", "Лошара", 72);
        Dog PitDog = new Dog("Graph", "Смирнов", "Питбудь");

        Mouse BuldogMouse = new Mouse("Buldog", 144, 10);
        Cat RybaCat = new Cat("Ryba", "Рыбка Моя", 16);
        Dog KrepishDog = new Dog("Крепыш", "Мигмамбетов", "Мелкий");

        //напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        int age;
        String name;
        String nick;

        public Cat(String name, String nick, int age)
        {
            this.name = name;
            this.nick = nick;
            this.age = age;
        }
    }

    public static class Dog
    {
        String name;
        String soname;
        String nick;

        public Dog(String name, String soname,String nick)
        {
            this.name = name;
            this.soname = soname;
            this.nick = nick;
        }
    }

    //добавьте тут ваши классы

}
