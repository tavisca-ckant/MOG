package com.tavisca;

public class CreditTokenParser {
    public String[] parseCreditStatement(String statements) {
        String[] tokenParse = statements.split(" ");
        String[] tokens = new String[tokenParse.length - 2];
        int counter = 0;
        for (String word : tokenParse) {
            if (!word.equals("is") && !word.equals("Credits"))
                tokens[counter++] = word;

            else
                continue;
        }
        return tokens;

    }
}
