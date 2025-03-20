package com.github.sebing.padding;

public final class NonRegexNumberPadder implements NumberPadder {
    private final int paddingCountX;
    private final String input;

    public NonRegexNumberPadder(final String input, final int paddingCountX) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null  or empty");
        }
        if (paddingCountX <= 0) {
            throw new IllegalArgumentException("Padding length must be greater than zero");
        }
        this.input = input;
        this.paddingCountX = paddingCountX;
    }

    @Override
    public String padNumbers() {
        final StringBuilder result = new StringBuilder();
        final StringBuilder numberBuffer = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() > 0) {
                    result.append(padNumber(numberBuffer.toString()));
                    numberBuffer.setLength(0);
                }
                result.append(c);
            }
        }

        if (numberBuffer.length() > 0) {
            result.append(padNumber(numberBuffer.toString()));
        }

        return result.toString();
    }

    private String padNumber(final String number) {
        return String.format("%0" + paddingCountX + "d", Integer.parseInt(number));
    }

    public static void main(final String[] args) {
        System.out.println(new NonRegexNumberPadder("James Bond 7", 3).padNumbers());       // "James Bond 007"
        System.out.println(new NonRegexNumberPadder("PI=3.14", 2).padNumbers());           // "PI=03.14"
        System.out.println(new NonRegexNumberPadder("It's 3:13pm", 2).padNumbers());       // "It's 03:13pm"
        System.out.println(new NonRegexNumberPadder("It's 12:13pm", 2).padNumbers());      // "It's 12:13pm"
        System.out.println(new NonRegexNumberPadder("99UR1337", 6).padNumbers());         // "000099UR001337"
    }
}