package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 12;
    }

    @Override
    public String getDescription() {
        String result = super.getDescription();
        result += " Моя страна - " + Country.UKRAINE;
        result += ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return result;
    }
}
