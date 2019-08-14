package com.tavisca;

import java.util.HashMap;

public class CreditValueForMetal {
    MapValidator mapValidator;

    public CreditValueForMetal(MapValidator mapValidator) {
        this.mapValidator = mapValidator;
    }

    public static HashMap<String, Integer> metalCreditValueMap = new HashMap<>();

    public int getValueForMetals(String metal) {
        return metalCreditValueMap.get(metal);

    }

    public int storeCreditValueOfMetal(String statement) {
        CreditTokenParser creditTokenParser = new CreditTokenParser();
        RomanToInteger romanToInteger = new RomanToInteger();
        String[] metal = creditTokenParser.parseCreditStatement(statement);
        String creditValue = metal[metal.length - 1];
        String metalName = metal[metal.length - 2];
        String roman = "";
        for (int i = 0; i < metal.length - 2; i++) {
            roman = roman + MapValidator.galacticWordRomanMap.get(metal[i]);
        }
        int result = Integer.parseInt(creditValue) / romanToInteger.convertRomanToInteger(roman);
        metalCreditValueMap.put(metalName, result);
        return result;

    }
}
