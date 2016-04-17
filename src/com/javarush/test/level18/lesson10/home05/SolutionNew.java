package com.javarush.test.level18.lesson10.home05;

/* ���㣫���� �ᥫ
����� � ���᮫� 2 ����� 䠩��
���� 䠩� ᮤ�ন� ����⢥���(�஡��) �᫠, ࠧ������� �஡����. ���ਬ��, 3.1415
���㣫��� �᫠ �� 楫�� � ������� �१ �஡�� �� ��ன 䠩�
������� ��⮪�. �� �ᯮ�짮���� try-with-resources
�ਭ樯 ���㣫����:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class SolutionNew {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        BufferedWriter fileWr = new BufferedWriter(new FileWriter(rd.readLine()));
        rd.close();

        while (fileRd.ready()) {
            String[] numbers = fileRd.readLine().split(" ");

            for (String number : numbers) {
                double dNumber = Double.valueOf(number);
                int result = (int) Math.round(dNumber);
                fileWr.write(result + " ");
            }
        }

        fileRd.close();
        fileWr.close();
    }
}
