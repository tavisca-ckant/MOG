package com.tavisca;

public class MerchantGalaxy {

    public String handleQueries(String query) {
        if (query.startsWith("how much is"))
            return handleRomanQueries(query);

        else if (query.startsWith("how many Credits is"))
            return handleCreditQueries(query);

        return "I have no idea what you are talking about";
    }

    private String handleCreditQueries(String query) {
        String[] words = parseQueryStatement(query);
        return getValueForMetals(words);
    }

    private String getValueForMetals(String[] words) {
        String roman = "";
        String metalName = words[words.length - 1];
        String result = "";
        for (int i = 0; i < words.length - 1; i++) {
            roman += MapValidator.galacticWordRomanMap.get(words[i]);
            result += words[i] + " ";
        }
        return result + metalName + " is " + RomanToInteger.convertRomanToInteger(roman) * CreditValueForMetal.metalCreditValueMap.get(metalName) + " Credits";

    }

    public String getValueForGalacticWords(String[] words) {
        String roman = "";
        String result = "";
        for (String word : words) {
            roman += MapValidator.galacticWordRomanMap.get(word);
            result += word + " ";
        }
        return result + "is " + RomanToInteger.convertRomanToInteger(roman);
    }

    private String handleRomanQueries(String query) {
        String[] words = parseQueryStatement(query);
        return getValueForGalacticWords(words);

    }

    private String[] parseQueryStatement(String query) {
        String[] parseRomanQuery = query.split(" ");
        int indexOfIs = -1;
        int indexOfQuestionMark = -1;
        int c = 0;

        for (int i = 0; i < parseRomanQuery.length; i++) {
            if (parseRomanQuery[i].equals("is"))
                indexOfIs = i;
            if (parseRomanQuery[i].equals("?"))
                indexOfQuestionMark = i;
        }
        String[] words = new String[indexOfQuestionMark - indexOfIs - 1];
        for (int i = indexOfIs + 1; i < indexOfQuestionMark; i++)
            words[c++] = parseRomanQuery[i];
        return words;
    }
}
