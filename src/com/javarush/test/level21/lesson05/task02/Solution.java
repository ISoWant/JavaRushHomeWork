package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        Solution n = (Solution) o;
        if (first == null && last == null)
            if (n.first == null && last == null)
                return true;
            else
                return false;
        if (first == null)
            if (n.first != null)
                return false;
            else return n.last.equals(last);
        if (last == null)
            if (n.last != null)
                return false;
            else return n.first.equals(first);

        return first.equals(n.first) && last.equals(n.last);
    }

    @Override
    public int hashCode() {
        if (this == null)
            return 0;
        if (first == null && last == null)
            return 0;

        if (first != null)
            return first.length();

        if (last != null)
            return last.length();

        return first.length() + last.length();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Мышь", "Mouse"));
        System.out.println(s.contains(new Solution("Мышь", "Mouse")));
    }
}
