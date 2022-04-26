package com.example.demo.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeToStringUtilTest {

    TimeToStringUtil TTS = new TimeToStringUtil();

    @Test
    void convertFor4() {
        // Arrange
        int testTime = 4;

        String expected = "night";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor5() {
        // Arrange
        int testTime = 5;

        String expected = "morning";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor11() {
        // Arrange
        int testTime = 11;

        String expected = "morning";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor12() {
        // Arrange
        int testTime = 12;

        String expected = "afternoon";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor15() {
        // Arrange
        int testTime = 15;

        String expected = "afternoon";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor16() {
        // Arrange
        int testTime = 16;

        String expected = "evening";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor21() {
        // Arrange
        int testTime = 21;

        String expected = "evening";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

    @Test
    void convertFor22() {
        // Arrange
        int testTime = 22;

        String expected = "night";

        // Act
        String actual = TTS.convert(testTime);

        // Assert

        assertEquals(expected, actual);
    }

}