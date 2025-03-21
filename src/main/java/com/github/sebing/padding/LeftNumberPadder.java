package com.github.sebing.padding;

public final class LeftNumberPadder implements NumberPadder {

    private final String input;
    private final int paddingCountX;

    public LeftNumberPadder(final String input, final int paddingCountX) {
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
        final StringBuilder result = new StringBuilder();
        final int length = input.length();

        for(int i = 0;i < length;){
            final char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                // Start of a potential number (could be an integer or a decimal)
                final StringBuilder numberBuffer = new StringBuilder();

                // Collect the integer part
                while (i < length && Character.isDigit(input.charAt(i))) {
                    numberBuffer.append(input.charAt(i));
                    i++;
                }

                final String integerPart = numberBuffer.toString();

                // Check if it's a decimal number
                if (i < length && input.charAt(i) == '.' && (i + 1 < length) && Character.isDigit(input.charAt(i + 1))) {
                    // It's a decimal! Pad the integer part, then add the '.' and fractional part as-is.
                    final StringBuilder fractionalPart = new StringBuilder();

                    i++; // skip the dot
                    fractionalPart.append('.');

                    // Collect fractional digits
                    while (i < length && Character.isDigit(input.charAt(i))) {
                        fractionalPart.append(input.charAt(i));
                        i++;
                    }

                    result.append(padInteger(integerPart)).append(fractionalPart);

                } else {
                    // It's just an integer, pad it!
                    result.append(padInteger(integerPart));
                }

            } else {
                // Not a digit, just append it
                result.append(currentChar);
                i++;
            }
        }

        return result.toString();
    }

    private String padInteger(final String number) {
        final int num = Integer.parseInt(number);
        return String.format("%0" + paddingCountX + "d", num);
    }

    public static void main(String[] args) {
        System.out.println(new LeftNumberPadder("James Bond 7", 3).padNumbers());       // James Bond 007
        System.out.println(new LeftNumberPadder("PI=3.14", 2).padNumbers());           // PI=03.14
        System.out.println(new LeftNumberPadder("PI=3.14", 4).padNumbers());           // PI=0003.14
        System.out.println(new LeftNumberPadder("It's 3:13pm", 2).padNumbers());       // It's 03:13pm
        System.out.println(new LeftNumberPadder("It's 12:13pm", 2).padNumbers());      // It's 12:13pm
        System.out.println(new LeftNumberPadder("99UR1337", 6).padNumbers());          // 000099UR001337
    }
}
