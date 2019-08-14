package com.tavisca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntegerTest {

    @Test
    public void romanToInteger() {
        RomanToInteger romanToInteger=new RomanToInteger();
        assertEquals(4, romanToInteger.convertRomanToInteger("IV"));
        assertEquals(1944, romanToInteger.convertRomanToInteger("MCMXLIV"));

    }
}
