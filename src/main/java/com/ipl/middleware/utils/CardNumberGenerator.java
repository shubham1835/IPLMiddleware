package com.ipl.middleware.utils;


/**
 * A credit card number generator.
 *
 * @author Shubham Gosewade
 */
public class CardNumberGenerator {
    private CardNumberGenerator() {
    }

    public static String generateRandomCreditCardNumber(String bin, String midSeq, int length) {

        // The number of random digits that we need to generate is equal to the
        // total length of the card number minus the start digits given by the
        // user, minus the check digit at the end.
        int randomNumberLength = length - (bin.length() + 1);
        StringBuilder buffer = new StringBuilder(bin);
        buffer.append(midSeq);
        // Do the Luhn algorithm to generate the check digit.
        int checkDigit = getCheckDigit(buffer.toString());
        buffer.append(checkDigit);

        return buffer.toString();
    }

    /**
     * Generates the check digit required to make the given credit card number
     * valid (i.e. pass the Luhn check)
     *
     * @param number The credit card number for which to generate the check digit.
     * @return The check digit required to make the given credit card number
     * valid.
     */
    private static int getCheckDigit(String number) {

        // Get the sum of all the digits, however we need to replace the value
        // of every other digit with the same digit multiplied by 2. If this
        // multiplication yields a number greater than 9, then add the two
        // digits together to get a single digit number.
        //
        // The digits we need to replace will be those in an even position for
        // card numbers whose length is an even number, or those is an odd
        // position for card numbers whose length is an odd number. This is
        // because the Luhn algorithm reverses the card number, and doubles
        // every other number starting from the second number from the last
        // position.
        int sum = 0;
        int remainder = (number.length() + 1) % 2;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == remainder) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        int checkDigit = ((mod == 0) ? 0 : 10 - mod);

        return checkDigit;
    }


}
