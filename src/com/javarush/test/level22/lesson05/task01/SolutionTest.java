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
        assertEquals("����, ����� ����������! ���",
                getPartOfString("����������� ����, ����� ����������! ��� ���?"));
    }

    @Test
    public void testGetPartOfStringByExample() throws TooShortStringException {
        assertEquals("- ������ ������ ��������",
                getPartOfString("JavaRush - ������ ������ �������� Java."));
    }

    @Test(expected = TooShortStringException.class)
    public void testGetPartOfStringOnNull() throws TooShortStringException {
        getPartOfString(null);
    }

    @Test(expected = TooShortStringException.class)
    public void testGetPartOfStringOnException() throws TooShortStringException {
        getPartOfString("������� �������� �������");
    }
}
