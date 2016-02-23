package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution {
    private SubSolution(boolean boo){
        super(boo);
    }

    private SubSolution(int value) {
        super(value);
    }

    private SubSolution(String st) {
        super(st);
    }
    SubSolution(int a, int b) {
        super(a, b);
    }

    SubSolution(int a, String st) {
        super(a, st);
    }

    SubSolution(String a, int b) {
        super(a, b);
    }

    protected SubSolution(float value) {
        super(value);
    }

    protected SubSolution(double value) {
        super(value);
    }

    protected SubSolution(long value) {
        super(value);
    }

    public SubSolution(String[] text) {
        super(text);
    }

    public SubSolution(int[] matrix) {
        super(matrix);
    }

    public SubSolution(short count) {
        super(count);
    }
}
