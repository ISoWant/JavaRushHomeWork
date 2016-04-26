package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C cloneC;
            int cloneI = super.getI();
            int cloneJ = super.getJ();
            String cloneName;
            if (super.name != null) {
                cloneName = super.getName();
                cloneC = new C(cloneI, cloneJ, cloneName);
                return cloneC;
            } else return (C) super.clone();
        }
    }

    public static void main(String[] args) {
        A a = new A(1, 2);
        A cloneA;
        B b = new B(3, 4, "Name");
        B cloneB;
        C c = new C(5, 6, "Имя");
        C cloneC;
        try {
            cloneA = a.clone();
            System.out.println(a.getI() + " " + a.getJ());
            System.out.println(cloneA.getI() + " " + cloneA.getJ());
           cloneB = b.clone();
            System.out.println(b.getI() + " " + b.getJ() + " " + b.getName());
            System.out.println(cloneB.getI() + " " + cloneB.getJ() + " " + cloneB.getName());
            cloneC = c.clone();
            System.out.println(c.getI() + " " + c.getJ() + " " + c.getName());
            System.out.println(cloneC.getI() + " " + cloneC.getJ() + " " + cloneC.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
