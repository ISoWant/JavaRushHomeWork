package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution_old создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов
    и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов,
    которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution {

    public static void main(String[] args) {

        Set<Cat> cats = createCats();

        Iterator<Cat> it = cats.iterator();
        cats.remove(it.next());

        //напишите тут ваш код. пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();
        Cat cat1 = new Cat("Вискас");
        Cat cat2 = new Cat("Бобик");
        Cat cat3 = new Cat("Бесконечность");
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        //напишите тут ваш код. пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        Iterator<Cat> it = cats.iterator(); // пункт 4

        while (it.hasNext()) {
            Cat cat = it.next();
            System.out.println(cat);
        }
    }

    public static class Cat{
        private String name;

        Cat (String name) {
            this.name = name;
        }

    }// пункт 1
}
