package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scan;

        public PersonScannerAdapter(Scanner scan) {
            this.scan = scan;
        }

        @Override
        public Person read() throws IOException {
            String[] param = scan.nextLine().split(" ");

            int day = Integer.valueOf(param[3]);
            int month = Integer.valueOf(param[4]) - 1;
            int year = Integer.valueOf(param[5]);

            Calendar calendar = new GregorianCalendar(year, month, day);

            return new Person(param[1], param[2], param[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            scan.close();
        }
    }
}
