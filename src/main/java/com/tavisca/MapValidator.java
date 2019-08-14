package com.tavisca;

import java.util.HashMap;

public class MapValidator {

    private RomanToInteger romanToInteger;

    public MapValidator(RomanToInteger romanToInteger) {
        this.romanToInteger = romanToInteger;
    }

    public static HashMap<String, Character> galacticWordRomanMap = new HashMap<>();

    public char getRomanLiteralForWord(String word) {
        return galacticWordRomanMap.get(word);

    }

    public void storeRomanOfGalacticWordInMap(String word) {
        WordToRomanParser wordToRomanParser = new WordToRomanParser();
        String[] galacticWord = wordToRomanParser.wordToRomanParse(word);
        if (isValid(galacticWord[1].charAt(0)))
            galacticWordRomanMap.put(galacticWord[0], galacticWord[1].charAt(0));
    }

    private boolean isValid(char roman) {
        return romanToInteger.romanToIntegerMap.containsKey(roman);

    }
}
