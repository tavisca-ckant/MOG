package com.tavisca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class answerToQueries {

    @Test
    public void answerToQueries(){
        RomanToInteger romanToInteger=new RomanToInteger();
        MerchantGalaxy merchantGalaxy=new MerchantGalaxy();
        MapValidator mapValidator=new MapValidator(romanToInteger);
        CreditValueForMetal creditValueForMetal=new CreditValueForMetal(mapValidator);
        mapValidator.storeRomanOfGalacticWordInMap("glob is I");
        mapValidator.storeRomanOfGalacticWordInMap("prok is V");
        mapValidator.storeRomanOfGalacticWordInMap("pish is X");
        mapValidator.storeRomanOfGalacticWordInMap("tegj is L");
        creditValueForMetal.storeCreditValueOfMetal("glob glob Silver is 34 Credits");
        creditValueForMetal.storeCreditValueOfMetal("glob prok Gold is 57800 Credits");
        creditValueForMetal.storeCreditValueOfMetal("pish pish Iron is 3910 Credits");
        assertEquals("pish tegj glob glob is 42",merchantGalaxy.handleQueries("how much is pish tegj glob glob ?"));
        assertEquals("glob prok Silver is 68 Credits",merchantGalaxy.handleQueries("how many Credits is glob prok Silver ?"));
        assertEquals("glob prok Gold is 57800 Credits",merchantGalaxy.handleQueries("how many Credits is glob prok Gold ?"));
        assertEquals("I have no idea what you are talking about",merchantGalaxy.handleQueries("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
        //assertEquals("glob prok Iron is 782 Credits",merchantGalaxy.handleQueries("how many Credits is glob prok Iron ?"));
    }

}
