package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        String [] stTokens;
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        stTokens = new String[tokens.size()];
        for (int i = 0; i < stTokens.length; i++) {
            stTokens[i] = tokens.get(i);
        }

        return stTokens;
    }
}
