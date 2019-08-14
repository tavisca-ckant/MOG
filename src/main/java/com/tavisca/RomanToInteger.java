package com.tavisca;

import java.util.HashMap;

public class RomanToInteger {

    public static HashMap<Character, Integer> romanToIntegerMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);

    }};

    public static int convertRomanToInteger(String roman) {

        if (!isValid(roman)) {
            throw new RuntimeException("Invalid Roman Format");
        }
        int result = 0;
        char lastchar = 'M';
        for (char character : roman.toCharArray()) {
            result += romanToIntegerMap.get(character);

            if (romanToIntegerMap.get(lastchar) < romanToIntegerMap.get(character)) {
                result -= romanToIntegerMap.get(lastchar) * 2;
            }
            lastchar = character;
        }
        return result;
    }

    private static boolean isValid(String roman) {
        return roman.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

}


