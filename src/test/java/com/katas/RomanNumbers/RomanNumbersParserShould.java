package com.katas.RomanNumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.*;

public class RomanNumbersParserShould {

    private RomanNumbersParser romanNumbersParser;

    @BeforeEach
    void setUp() {
        romanNumbersParser = new RomanNumbersParser();
        romanNumbersParser.init();
    }

    @ParameterizedTest
    @CsvSource({"1,I", "2,II", "3,III", "4,IV", "5,V", "6,VI", "7,VII", "8,VIII", "9,IX", "10,X", "20,XX", "30,XXX"})
    void returnExpectedRomanNumeralWhenPassedANumberUnder30(int value, String romanNum) {
        String result = romanNumbersParser.parse(value);
        assertThat(result).isEqualTo(romanNum);
    }

    @ParameterizedTest
    @CsvSource({"0,0"})
    void returnExpectedRomanNumeralWhenPassedANumber0(int value, String romanNum) {
        String result = romanNumbersParser.parse(value);
        assertThat(result).isEqualTo(romanNum);
    }

    @ParameterizedTest
    @CsvSource({"40,XL", "50,L", "60,LX", "70,LXX", "80,LXXX", "90,XC"})
    void returnExpectedRomanNumeralWhenPassedANumberBetween40And90(int value, String romanNum) {
        String result = romanNumbersParser.parse(value);
        assertThat(result).isEqualTo(romanNum);
    }

    @ParameterizedTest
    @CsvSource({"100,C", "200,CC", "300,CCC", "400, CD", "500,D", "600,DC", "700, DCC", "800, DCCC", "900, CM"})
    void returnExpectedRomanNumeralWhenPassedANumberBetween100And900(int value, String romanNum) {
        String result = romanNumbersParser.parse(value);
        assertThat(result).isEqualTo(romanNum);
    }

    @ParameterizedTest
    @CsvSource({"4,IV", "9,IX", "29,XXIX", "80,LXXX", "294,CCXCIV", "2019,MMXIX"})
    void returnX(int value, String romanNum) {
        String result = romanNumbersParser.parse(value);
        assertThat(result).isEqualTo(romanNum);
    }
}
