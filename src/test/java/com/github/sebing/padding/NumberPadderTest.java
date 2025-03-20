package com.github.sebing.padding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

class NumberPadderTest {

    static Stream<Arguments> provideImplementations() {
        return Stream.of(
                Arguments.of(new RegexNumberPadder("James Bond 7", 3), "James Bond 007"),
                Arguments.of(new NonRegexNumberPadder("James Bond 7", 3), "James Bond 007"),

                Arguments.of(new RegexNumberPadder("It's 12:13pm", 2), "It's 12:13pm"),
                Arguments.of(new NonRegexNumberPadder("It's 12:13pm", 2), "It's 12:13pm"),

                Arguments.of(new RegexNumberPadder("PI=3.14", 2), "PI=03.14"),
                Arguments.of(new NonRegexNumberPadder("PI=3.14", 2), "PI=03.14"),

                Arguments.of(new RegexNumberPadder("99UR1337", 6), "000099UR001337"),
                Arguments.of(new NonRegexNumberPadder("99UR1337", 6), "000099UR001337"),

                Arguments.of(new RegexNumberPadder("Code 007", 3), "Code 007"),
                Arguments.of(new NonRegexNumberPadder("Code 007", 3), "Code 007"),

                Arguments.of(new RegexNumberPadder("Level 1 2 3", 2), "Level 01 02 03"),
                Arguments.of(new NonRegexNumberPadder("Level 1 2 3", 2), "Level 01 02 03"),

                Arguments.of(new RegexNumberPadder("9 Lives", 2), "09 Lives"),
                Arguments.of(new NonRegexNumberPadder("9 Lives", 2), "09 Lives"),

                Arguments.of(new RegexNumberPadder("Hello World!", 3), "Hello World!"),
                Arguments.of(new NonRegexNumberPadder("Hello World!", 3), "Hello World!"),

                Arguments.of(new RegexNumberPadder("ID 123456", 3), "ID 123456"),
                Arguments.of(new NonRegexNumberPadder("ID 123456", 3), "ID 123456"),

                Arguments.of(new RegexNumberPadder("A", 2), "A"),
                Arguments.of(new NonRegexNumberPadder("A", 2), "A"),

                Arguments.of(new RegexNumberPadder("5", 3), "005"),
                Arguments.of(new NonRegexNumberPadder("5", 3), "005")
        );
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void testNumberPadding(NumberPadder padder, String expected) {
        assertEquals(expected, padder.padNumbers());
    }
}

