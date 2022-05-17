package com.katas.RomanNumbers;

import java.util.ArrayList;
import java.util.List;

public class RomanNumbersParser {

    List<RomanPair> romanList = new ArrayList<RomanPair>();

    public void init() {
        romanList.add(new RomanPair(1, "I"));
        romanList.add(new RomanPair(4, "IV"));
        romanList.add(new RomanPair(5, "V"));
        romanList.add(new RomanPair(9, "IX"));
        romanList.add(new RomanPair(10, "X"));
        romanList.add(new RomanPair(40, "XL"));
        romanList.add(new RomanPair(50, "L"));
        romanList.add(new RomanPair(90, "XC"));
        romanList.add(new RomanPair(100, "C"));
        romanList.add(new RomanPair(400, "CD"));
        romanList.add(new RomanPair(500, "D"));
        romanList.add(new RomanPair(900, "CM"));
        romanList.add(new RomanPair(1000, "M"));

    }

    public String parse(int arabicNumber) {
        String result = "";

        for (int i = romanList.size() - 1; i >= 0; i--) {
            int expectedArabicNumber = romanList.get(i).arabicNumber;
            String expectedRomanNumber = romanList.get(i).romanNumber;

            while (arabicNumber >= expectedArabicNumber) {
                result += expectedRomanNumber;
                arabicNumber -= expectedArabicNumber;
            }
        }

        return result == "" ? "0" : result;
    }
}

