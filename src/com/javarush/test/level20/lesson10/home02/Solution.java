package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Solution.A b = solution.new B();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        out.close();
        solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())));
    }

    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object obj = objectStream.readObject();
            if (obj instanceof A) {
                return (A) obj;
            } else {
                return  (B) obj;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class A implements Serializable {
        public A() {
            super();
        }
    }

    public class B extends A{

        public B() {
            super();
            System.out.println("inside B");
        }
    }
}
