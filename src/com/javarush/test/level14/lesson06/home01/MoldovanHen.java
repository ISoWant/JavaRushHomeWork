package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 19;
    }

    @Override
    public String getDescription() {
        String result = super.getDescription();
        result += " Моя страна - " + Country.MOLDOVA;
        result += ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return result;
    }
}