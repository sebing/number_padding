package com.github.sebing.padding;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

class NumberPadderTest {

    // Factory method to supply both implementations
    static Stream<NumberPadder> provideImplementations() {
        return Stream.of(
                new RegexNumberPadder("James Bond 7", 3),
                new NonRegexNumberPadder("James Bond 7", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void testSingleDigitPadding(NumberPadder padder) {
        assertEquals("James Bond 007", padder.padNumbers());
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void testNoPaddingNeeded(NumberPadder padder) {
        assertEquals("It's 12:13pm", new RegexNumberPadder("It's 12:13pm", 2).padNumbers());
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void testMixedContent(NumberPadder padder) {
        assertEquals("PI=03.14", new RegexNumberPadder("PI=3.14", 2).padNumbers());
        assertEquals("000099UR001337", new RegexNumberPadder("99UR1337", 6).padNumbers());
    }

    @Test
    void testEachImplementationSeparately() {
        NumberPadder regexPadder = new RegexNumberPadder("99UR1337", 6);
        NumberPadder nonRegexPadder = new NonRegexNumberPadder("99UR1337", 6);

        assertEquals("000099UR001337", regexPadder.padNumbers());
        assertEquals("000099UR001337", nonRegexPadder.padNumbers());
    }
}

