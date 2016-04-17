package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRd = new BufferedReader(new FileReader(rd.readLine()));
        rd.close();

        String tag = "<" + args[0];
        String closeTag = "</" + args[0] + ">";
        ArrayList<String> buff = new ArrayList<>();

        while (fileRd.ready()) {
            buff.add(fileRd.readLine());
        }

        fileRd.close();

        for (int lineNumber = 0; lineNumber < buff.size(); lineNumber++) {
            int start = buff.get(lineNumber).indexOf(tag);
            String draft = buff.get(lineNumber);

            while (start != -1) {
                draft = draft.substring(start + tag.length(), draft.length());
                System.out.println(tag + findClosedTag(draft, buff, lineNumber, tag, closeTag, 0));
                start = draft.indexOf(tag);
            }
        }
    }

    private static String findClosedTag(String draft, ArrayList<String> buff, int lineNumber, String tag, String closeTag, int counterOpenTag) {
        int indexOfNextTeg = draft.indexOf(tag);
        int indexOfCloseTag = draft.indexOf(closeTag);
        String text = draft;

        if (indexOfCloseTag > indexOfNextTeg &&     //Если в строке первым встречается аналогичный открывающийся тег, то
                ((indexOfCloseTag == -1 && indexOfNextTeg != -1) ||
                (indexOfCloseTag != -1 && indexOfNextTeg != -1))) {
            counterOpenTag++;                       //увеличиваем счётчик открытых тегов и в черновик записываем строку
            draft = draft.substring(indexOfNextTeg + tag.length(), draft.length());//вырезая из неё тег и текст до него.
            text = text.substring(0, indexOfNextTeg + tag.length());//А в текст между тегами записываем отрезанную часть.
        } else if (counterOpenTag != 0 && indexOfCloseTag >= 0) {           //Если сначала встретился закрывающий тег, но счётчик открытых тегов
            counterOpenTag--;                       //не раван нулю, то дикрементируем счётчик, а в черновик записываем
            draft = draft.substring(indexOfCloseTag + closeTag.length(), draft.length());//строку, вырезав из неё тег и
            text = text.substring(0, indexOfCloseTag + closeTag.length());//текст до него, записав их в text.
        } else if (indexOfCloseTag != -1) {         //Если счётчик открытых тегов равен нулю и первым встретился закры-
            text = draft.substring(0, indexOfCloseTag + closeTag.length());//вающий тег, то это искомый тег, возвращаем
            return text;                           //текст до этого тега, включительно.
        } else {
            lineNumber++;//Это означает, что в данной строке тегов такого типа не встретилось,
           if (lineNumber < buff.size())draft = buff.get(lineNumber);       //записываем в черновик следующую строчку из массива.
        }
        if (lineNumber < buff.size()) {
            text += findClosedTag(draft, buff, lineNumber, tag, closeTag, counterOpenTag);
        }
        return text;
    }
}