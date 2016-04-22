package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution_old создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution_old.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution_old.
*/

public class Solution {
    private Solution(boolean boo){}

    private Solution(int number) {
    }

    private Solution(String name) {
    }

    protected Solution(float value) {
    }

    protected Solution(double value) {
    }

    protected Solution(long value) {
    }

    public Solution(Object pub_obj) {
    }

    public Solution(int[] matrix) {
    }

    public Solution(short count) {
    }

    Solution(int a, int b){
    }

    Solution(int a, String st) {
    }

    Solution(String a, int b) {
    }
}

