package com.javarush.test.level22.lesson05.task01;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static com.javarush.test.level22.lesson05.task01.Solution.*;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Rule
    public final Timeout timeout = new Timeout(10);

    @Test
    public void testGetPartOfString() throws TooShortStringException {
        assertEquals("тебя, юнный падаванчик! Или",
                getPartOfString("Приветствую тебя, юнный падаванчик! Или нет?"));
    }

    @Test
    public void testGetPartOfStringByExample() throws TooShortStringException {
        assertEquals("- лучший сервис обучения",
                getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    @Test(expected = TooShortStringException.class)
    public void testGetPartOfStringOnNull() throws TooShortStringException {
        getPartOfString(null);
    }

    @Test(expected = TooShortStringException.class)
    public void testGetPartOfStringOnException() throws TooShortStringException {
        getPartOfString("Слишком короткая строчка");
    }
}
