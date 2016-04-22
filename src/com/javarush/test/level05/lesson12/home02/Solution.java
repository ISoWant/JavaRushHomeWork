package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution_old создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man JackMan = new Man("Джек", 27, "Новая пирожковая, 10");
        Man NikakoyMan = new Man("Никакой", 17, "Урна у вокзала");

        Woman LadyWoman = new Woman("Джесика", 19, "У меня дома");
        Woman BlondWoman = new Woman("Рейчил", 20, "Здесь же");

        System.out.println(JackMan.name + " " + JackMan.age + " " + JackMan.address);
        System.out.println(NikakoyMan.name + " " + NikakoyMan.age + " " + NikakoyMan.address);

        System.out.println(LadyWoman.name + " " + LadyWoman.age + " " + LadyWoman.address);
        System.out.println(BlondWoman.name + " " + BlondWoman.age + " " + BlondWoman.address);

        //создай по два объекта каждого класса тут

        //выведи их на экран тут
    }

    public static class Man
    {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }

    public static class Woman
    {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    //добавьте тут ваши классы
}
