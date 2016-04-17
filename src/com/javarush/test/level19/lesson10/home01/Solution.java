package com.javarush.test.level19.lesson10.home01;

/* ��⠥� ��௫���
� ��⮤ main ���� ��ࠬ��஬ ��室�� ��� 䠩��.
� �⮬ 䠩�� ������ ��ப� ����� ᫥���騩 ���:
��� ���祭��
��� [���] - String, [���祭��] - double. [���] � [���祭��] ࠧ������ �஡����

��� ������� ����� ������� �㬬� ��� ��� ���祭��
�� ����� �뢥�� � ���᮫�, �।���⥫쭮 �����஢�� � �������饬 ���浪� �� �����
������� ��⮪�. �� �ᯮ�짮���� try-with-resources

�ਬ�� �室���� 䠩��:
���஢ 2
����஢ 6
������ 1.35
���஢ 3.1

�ਬ�� �뢮��:
������ 1.35
���஢ 5.1
����஢ 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRd = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> payroll = new TreeMap<>();
        String position;

        while (fileRd.ready()) {
            position = fileRd.readLine();
            String[] parameter = position.split(" ");

            if (payroll.containsKey(parameter[0])) {
                Double value = payroll.get(parameter[0]) + Double.valueOf(parameter[1]);
                payroll.put(parameter[0], value);
            } else {
                payroll.put(parameter[0], Double.valueOf(parameter[1]));
            }
        }

        fileRd.close();

        for (String name : payroll.keySet()) {
            System.out.println(name + " " + payroll.get(name));
        }

    }
}
