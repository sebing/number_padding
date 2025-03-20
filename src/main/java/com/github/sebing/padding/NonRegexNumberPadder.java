package com.github.sebing.padding;

public final class NonRegexNumberPadder implements NumberPadder {
    private final int X;
    private final String input;

    public NonRegexNumberPadder(final String input, final int X) {
        this.input = input;
        this.X = X;
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
        return String.format("%0" + X + "d", Integer.parseInt(number));
    }

    public static void main(final String[] args) {
        System.out.println(new NonRegexNumberPadder("James Bond 7", 3).padNumbers());       // "James Bond 007"
        System.out.println(new NonRegexNumberPadder("PI=3.14", 2).padNumbers());           // "PI=03.14"
        System.out.println(new NonRegexNumberPadder("It's 3:13pm", 2).padNumbers());       // "It's 03:13pm"
        System.out.println(new NonRegexNumberPadder("It's 12:13pm", 2).padNumbers());      // "It's 12:13pm"
        System.out.println(new NonRegexNumberPadder("99UR1337", 6).padNumbers());         // "000099UR001337"
    }
}