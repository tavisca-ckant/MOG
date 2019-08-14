package com.tavisca;

public class QuestionsTokensParser {

    public String[] parseQuestionmarkStatements(String query) {
        String[] tokensParse = query.split(" is ");
        String[] parseQues = tokensParse[1].split(" ");
        int i;
        String[] tokenParser=new String[parseQues.length-1];
        for(i=0;i<parseQues.length-1;i++)
            tokenParser[i]=parseQues[i];

    return tokenParser;
    }
}
