package com.tavisca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidMapTest {

    @Test
    public void validMapForGalacticWordOfRoman(){
        RomanToInteger romanToInteger=new RomanToInteger();
        MapValidator mapValidator=new MapValidator(romanToInteger);
        mapValidator.storeRomanOfGalacticWordInMap("glob is I");
        mapValidator.storeRomanOfGalacticWordInMap("prok is V");
        mapValidator.storeRomanOfGalacticWordInMap("pish is X");
        mapValidator.storeRomanOfGalacticWordInMap("tegj is L");
        assertEquals('I',mapValidator.getRomanLiteralForWord("glob"));
        assertEquals('V',mapValidator.getRomanLiteralForWord("prok"));
        assertEquals('X',mapValidator.getRomanLiteralForWord("pish"));
        assertEquals('L',mapValidator.getRomanLiteralForWord("tegj"));
    }

    @Test
    public void storeMetalsCreditValue(){
        RomanToInteger romanToInteger=new RomanToInteger();
        MapValidator mapValidator=new MapValidator(romanToInteger);
        CreditValueForMetal creditValueForMetal=new CreditValueForMetal(mapValidator);
        mapValidator.storeRomanOfGalacticWordInMap("glob is I");
        mapValidator.storeRomanOfGalacticWordInMap("prok is V");
        mapValidator.storeRomanOfGalacticWordInMap("pish is X");
        mapValidator.storeRomanOfGalacticWordInMap("tegj is L");
        creditValueForMetal.storeCreditValueOfMetal("glob glob Silver is 34 Credits");
        creditValueForMetal.storeCreditValueOfMetal("glob prok Gold is 57800 Credits");
        creditValueForMetal.storeCreditValueOfMetal("pish pish Iron is 3910 Credits");

        Assert.assertEquals(17,creditValueForMetal.getValueForMetals("Silver"),0.001);
        Assert.assertEquals(14450,creditValueForMetal.getValueForMetals("Gold"),0.001);
        Assert.assertEquals(195.5,creditValueForMetal.getValueForMetals("Iron"),0.5);
    }
}
