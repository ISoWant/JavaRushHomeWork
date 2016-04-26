package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* �㪢� ?�? � �㪢� ?�?
1. ������ ᯨ᮪ ᫮�, ������� ��� ᠬ����⥫쭮.
2. ��⮤ fix ������:
2.1. 㤠���� �� ᯨ᪠ ��ப �� ᫮��, ᮤ�ঠ騥 �㪢� ?�?
2.2. 㤢������ �� ᫮�� ᮤ�ঠ騥 �㪢� ?�?.
2.3. �᫨ ᫮�� ᮤ�ন� � �㪢� ?�? � �㪢� ?�?, � ��⠢��� �� ᫮�� ��� ���������.
2.4. � ��㣨�� ᫮���� ��祣� �� ������.
�ਬ��:
஧�
���
����
��室�� �����:
���
����
����
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("஧�"); //0
        list.add("���"); //1
        list.add("����"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        String s;
        System.out.println(list.size());

        for (int index = 0; index < list.size(); index++) {
            s = list.get(index);
            char[] charArray = s.toCharArray();
            int tmpr = 0, tmpl = 0;

            for (int character = 0; character < s.length(); character++) {
                if (charArray[character] == '�' && tmpr == 0) {
                    tmpr++;
                } else if (charArray[character] == '�' && tmpl == 0) {
                    tmpl++;
                }
            }
            if (tmpl < tmpr) {
                list.remove(index);
            }else if (tmpl > tmpr) {
                list.add(index, list.get(index));
                index++;
            }
        }
        return list;
    }
}