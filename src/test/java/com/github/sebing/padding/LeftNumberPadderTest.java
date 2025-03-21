package com.github.sebing.padding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftNumberPadderTest {
    @Test
    void testSingleDigitPadding() {
        assertEquals("James Bond 007", new LeftNumberPadder("James Bond 7", 3).padNumbers());
        assertEquals("It's 03:13pm", new LeftNumberPadder("It's 3:13pm", 2).padNumbers());
    }

    @Test
    void testNoPaddingNeeded() {
        assertEquals("It's 12:13pm", new LeftNumberPadder("It's 12:13pm", 2).padNumbers());
    }

    @Test
    void testMixedContent() {
        assertEquals("PI=03.14", new LeftNumberPadder("PI=3.14", 2).padNumbers());
        assertEquals("000099UR001337", new LeftNumberPadder("99UR1337", 6).padNumbers());
    }

    @Test
    void testLeadingZerosInInput() {
        assertEquals("Code 007", new LeftNumberPadder("Code 007", 3).padNumbers());
    }

    @Test
    void testMultipleNumbersInSequence() {
        assertEquals("Level 01 02 03", new LeftNumberPadder("Level 1 2 3", 2).padNumbers());
    }

    @Test
    void testNumbersAtStartAndEnd() {
        assertEquals("09 Lives", new LeftNumberPadder("9 Lives", 2).padNumbers());
        assertEquals("Chapter 005", new LeftNumberPadder("Chapter 5", 3).padNumbers());
    }

    @Test
    void testStringWithNoNumbers() {
        assertEquals("Hello World!", new LeftNumberPadder("Hello World!", 3).padNumbers());
    }

    @Test
    void testVeryLargeNumbers() {
        assertEquals("ID 123456", new LeftNumberPadder("ID 123456", 3).padNumbers());
    }

    @Test
    void testSingleCharacterStrings() {
        assertEquals("A", new LeftNumberPadder("A", 2).padNumbers());
        assertEquals("005", new LeftNumberPadder("5", 3).padNumbers());
    }

    @Test
    void testInvalidPaddingThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new RegexNumberPadder(null, 2));
        assertThrows(IllegalArgumentException.class, () -> new RegexNumberPadder("Hello", -1));
    }

    @Test
    void testWholeNumber() {
        assertEquals("PI=0003.14", new LeftNumberPadder("PI=3.14", 4).padNumbers());
    }

}