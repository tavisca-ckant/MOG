package com.tavisca;

public class WordToRomanParser {
    public String[] wordToRomanParse(String statement) {

        String[] statementParse=statement.split(" ");

        return new String[]{statementParse[0],statementParse[2]};
    }
}
