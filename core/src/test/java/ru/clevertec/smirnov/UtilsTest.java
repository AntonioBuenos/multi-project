package ru.clevertec.smirnov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1.1:2:50000000000",
            "17:3.5:94",
            "100500:10:0.1"
    },
            delimiter = ':')
    void isAllPositiveNumbersTest(String a, String b, String c) {
        assertTrue(Utils.isAllPositiveNumbers(a, b, c));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.1:2:0",
            "-17:3.5:94",
            "100500:fhtagn!:0.1"
    },
            delimiter = ':')
    void isNotAllPositiveNumbersTest(String a, String b, String c) {
        assertFalse(Utils.isAllPositiveNumbers(a, b, c));
    }

    @ParameterizedTest
    @NullSource
    void isNullTest(String number) {
        assertFalse(Utils.isAllPositiveNumbers(number));
    }
}
