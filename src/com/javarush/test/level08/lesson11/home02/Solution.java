package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution {

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> cats = new HashSet<Cat>();

        Cat cat1 = new Cat("Барбекю");
        Cat cat2 = new Cat("Валенок");
        Cat cat3 = new Cat("Валдис Пейдж");
        Cat cat4 = new Cat("Скумбрия");

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        //напишите тут ваш код

        return cats;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogs = new HashSet<Dog>();

        Dog dog1 = new Dog("Пупырка");
        Dog dog2 = new Dog("Планер");
        Dog dog3 = new Dog("Кисточка");

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        //напишите тут ваш код
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> pets = new HashSet<Object>();

        Iterator<Cat> itCat = cats.iterator();

        while (itCat.hasNext()) {
            pets.add(itCat.next());
        }

        Iterator<Dog> itDog = dogs.iterator();

        while (itDog.hasNext()) {
            pets.add(itDog.next());
        }

        //напишите тут ваш код
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Cat> itCat = cats.iterator();
        Cat cat;

        while (itCat.hasNext()) {
            cat = itCat.next();
            Iterator<Object> itPets = pets.iterator();
            while (itPets.hasNext()) {
                Object pet = itPets.next();
                if (cat.equals(pet)) {
                    itPets.remove();
                }
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        Iterator<Object> itPets = pets.iterator();

        while (itPets.hasNext()) {
            System.out.println(itPets.next());
        }

    }

    public static class Cat {
        private String name;

        Cat(String name) {
            this.name = name;
        }
    }

    public static class Dog {
        private String name;

        Dog(String name) {
            this.name = name;
        }
    }
     //напишите тут ваш код
}
