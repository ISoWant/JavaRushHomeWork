package com.javarush.test.level06.lesson11.home01;

/* Класс Cat и статическая переменная catCount
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная
catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat[] cats = new Cat[10];
        for(int i = 0; i < 10; i++)
        {
            cats[i] = new Cat();
        }//Cоздай тут 10 объектов Cat

        System.out.println(Cat.catCount);//Выведи тут на экран catCount
    }

    public static class Cat
    {
        static public int catCount;

        public Cat()
        {
            catCount++;
        }
        //Cоздай тут статическую переменную

        //Создай тут конструктор
    }

}
