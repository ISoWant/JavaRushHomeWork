package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;/* ����� � ᮣ���� �㪢�
������� �ணࠬ��, ����� ������ � ���������� ��ப� ⥪��.
�ணࠬ�� ������ �뢥�� �� �࠭ ��� ��ப�:
1. ��ࢠ� ��ப� ᮤ�ন� ⮫쪮 ����� �㪢�
2. ���� - ⮫쪮 ᮣ���� �㪢� � ����� �९������ �� ����񭭮� ��ப�.
�㪢� ᮥ������ �஡����, ������ ��ப� ������ �����稢����� �஡����.

�ਬ�� �����:
���� �뫠 ࠬ�.
�ਬ�� �뢮��:
� � � � � �
� � � � � � .
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String vowels = "";
        String others = "";
        char array[] = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (isVowel(array[i])) {
                vowels += array[i] + " ";

            } else if (array[i] != ' ') {
                others += array[i] + " ";
            }
        }

        System.out.println(vowels);
        System.out.println(others);
        //������ ��� ��� ���
    }


    public static char[] vowels = new char[]{'�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

    //��⮤ �஢����, ���᭠� �� �㪢�
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  //�ਢ���� ᨬ��� � ������ ॣ���� - �� ��������� � ����� �㪢��

        for (char d : vowels)   //�饬 �।� ���ᨢ� ������
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
