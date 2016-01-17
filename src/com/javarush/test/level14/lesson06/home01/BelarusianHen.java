package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 27;
    }

    @Override
    public String getDescription() {
        String result = super.getDescription();
        result += " Моя страна - " + Country.BELARUS;
        result += ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return result;
    }
}