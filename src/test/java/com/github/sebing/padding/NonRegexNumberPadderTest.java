package com.github.sebing.padding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonRegexNumberPadderTest {
    @Test
    void testSingleDigitPadding() {
        assertEquals("James Bond 007", new NonRegexNumberPadder("James Bond 7", 3).padNumbers());
        assertEquals("It's 03:13pm", new NonRegexNumberPadder("It's 3:13pm", 2).padNumbers());
    }

    @Test
    void testNoPaddingNeeded() {
        assertEquals("It's 12:13pm", new NonRegexNumberPadder("It's 12:13pm", 2).padNumbers());
    }

    @Test
    void testMixedContent() {
        assertEquals("PI=03.14", new NonRegexNumberPadder("PI=3.14", 2).padNumbers());
        assertEquals("000099UR001337", new NonRegexNumberPadder("99UR1337", 6).padNumbers());
    }

    @Test
    void testLeadingZerosInInput() {
        assertEquals("Code 007", new NonRegexNumberPadder("Code 007", 3).padNumbers());
    }

    @Test
    void testMultipleNumbersInSequence() {
        assertEquals("Level 01 02 03", new NonRegexNumberPadder("Level 1 2 3", 2).padNumbers());
    }

    @Test
    void testNumbersAtStartAndEnd() {
        assertEquals("09 Lives", new NonRegexNumberPadder("9 Lives", 2).padNumbers());
        assertEquals("Chapter 005", new NonRegexNumberPadder("Chapter 5", 3).padNumbers());
    }

    @Test
    void testStringWithNoNumbers() {
        assertEquals("Hello World!", new NonRegexNumberPadder("Hello World!", 3).padNumbers());
    }

    @Test
    void testVeryLargeNumbers() {
        assertEquals("ID 123456", new NonRegexNumberPadder("ID 123456", 3).padNumbers());
    }

    @Test
    void testSingleCharacterStrings() {
        assertEquals("A", new NonRegexNumberPadder("A", 2).padNumbers());
        assertEquals("005", new NonRegexNumberPadder("5", 3).padNumbers());
    }
}