package com.tavisca;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ParserTest {

    @Test
    public void wordToRomanParser()
    {
        WordToRomanParser wordToRomanParser=new WordToRomanParser();
        assertArrayEquals(new String[] {"glob","I"},wordToRomanParser.wordToRomanParse("glob is I"));
        assertArrayEquals(new String[] {"prok","V"},wordToRomanParser.wordToRomanParse("prok is V"));
        assertArrayEquals(new String[] {"pish","X"},wordToRomanParser.wordToRomanParse("pish is X"));
        assertArrayEquals(new String[] {"tegj","L"},wordToRomanParser.wordToRomanParse("tegj is L"));
    }
    @Test
    public void creditTokenParser(){

        CreditTokenParser creditTokenParser=new CreditTokenParser();
        assertArrayEquals(new String[] {"glob","glob","Silver","34"}, creditTokenParser.parseCreditStatement("glob glob Silver is 34 Credits"));
        assertArrayEquals(new String[] {"glob","prok","Gold","57800"}, creditTokenParser.parseCreditStatement("glob prok Gold is 57800 Credits"));
        assertArrayEquals(new String[] {"pish","pish","Iron","3910"}, creditTokenParser.parseCreditStatement("pish pish Iron is 3910 Credits"));
    }

    @Test
    public void parseQueryStatements(){
        QuestionsTokensParser questionsTokensParser=new QuestionsTokensParser();
        assertArrayEquals(new String[]{"pish","tegj","glob","glob"}, questionsTokensParser.parseQuestionmarkStatements("how much is pish tegj glob glob ?"));
        assertArrayEquals(new String[]{"glob","prok","Silver"}, questionsTokensParser.parseQuestionmarkStatements("how many Credits is glob prok Silver ?"));
        assertArrayEquals(new String[]{"glob","prok","Gold"}, questionsTokensParser.parseQuestionmarkStatements("how many Credits is glob prok Gold ?"));
        assertArrayEquals(new String[]{"glob","prok","Iron"}, questionsTokensParser.parseQuestionmarkStatements("how many Credits is glob prok Iron ?"));
    }
}
