package com.github.sebing.padding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNumberPadder implements NumberPadder {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private final int paddingCountX;
    private final String input;

    public RegexNumberPadder(final String input, final int paddingCountX) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        if (paddingCountX <= 0) {
            throw new IllegalArgumentException("Padding length must be greater than zero");
        }
        this.input = input;
        this.paddingCountX = paddingCountX;
    }



    @Override
    public String padNumbers() {
        final Matcher matcher = NUMBER_PATTERN.matcher(input);
        final StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            final String number = matcher.group();
            final String paddedNumber = String.format("%0" + paddingCountX + "d", Integer.parseInt(number));
            matcher.appendReplacement(result, paddedNumber);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(final String[] args) {
        System.out.println(new RegexNumberPadder("James Bond 7", 3).padNumbers());       // "James Bond 007"
        System.out.println(new RegexNumberPadder("PI=3.14", 2).padNumbers());           // "PI=03.14"
        System.out.println(new RegexNumberPadder("It's 3:13pm", 2).padNumbers());       // "It's 03:13pm"
        System.out.println(new RegexNumberPadder("It's 12:13pm", 2).padNumbers());      // "It's 12:13pm"
        System.out.println(new RegexNumberPadder("99UR1337", 6).padNumbers());         // "000099UR001337"
    }
}
