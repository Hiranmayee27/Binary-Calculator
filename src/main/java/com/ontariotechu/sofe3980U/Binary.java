package com.ontariotechu.sofe3980U;

/**
 * Represents an unsigned binary number.
 */
public class Binary {

    private String number = "0";

    /**
     * Creates a Binary object.
     *
     * @param number binary value containing only 0 and 1
     */
    public Binary(String number) {

        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }

        // Validate the input.
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);

            if (digit != '0' && digit != '1') {
                this.number = "0";
                return;
            }
        }

        // Remove leading zeros.
        int firstOne = 0;

        while (firstOne < number.length()
                && number.charAt(firstOne) == '0') {
            firstOne++;
        }

        if (firstOne == number.length()) {
            this.number = "0";
        } else {
            this.number = number.substring(firstOne);
        }
    }

    /**
     * Returns the stored binary value.
     *
     * @return binary value as a String
     */
    public String getValue() {
        return number;
    }

    /**
     * Adds two binary numbers.
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return sum of the two binary numbers
     */
    public static Binary add(Binary num1, Binary num2) {

        int index1 = num1.number.length() - 1;
        int index2 = num2.number.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0 || carry != 0) {

            int sum = carry;

            if (index1 >= 0) {
                sum += num1.number.charAt(index1) == '1' ? 1 : 0;
                index1--;
            }

            if (index2 >= 0) {
                sum += num2.number.charAt(index2) == '1' ? 1 : 0;
                index2--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return new Binary(result.reverse().toString());
    }

    /**
     * Performs bitwise OR on two binary numbers.
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return result of num1 OR num2
     */
    public static Binary or(Binary num1, Binary num2) {

        int index1 = num1.number.length() - 1;
        int index2 = num2.number.length() - 1;

        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {

            char digit1 = index1 >= 0
                    ? num1.number.charAt(index1)
                    : '0';

            char digit2 = index2 >= 0
                    ? num2.number.charAt(index2)
                    : '0';

            if (digit1 == '1' || digit2 == '1') {
                result.append('1');
            } else {
                result.append('0');
            }

            index1--;
            index2--;
        }

        return new Binary(result.reverse().toString());
    }

    /**
     * Performs bitwise AND on two binary numbers.
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return result of num1 AND num2
     */
    public static Binary and(Binary num1, Binary num2) {

        int index1 = num1.number.length() - 1;
        int index2 = num2.number.length() - 1;

        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {

            char digit1 = index1 >= 0
                    ? num1.number.charAt(index1)
                    : '0';

            char digit2 = index2 >= 0
                    ? num2.number.charAt(index2)
                    : '0';

            if (digit1 == '1' && digit2 == '1') {
                result.append('1');
            } else {
                result.append('0');
            }

            index1--;
            index2--;
        }

        return new Binary(result.reverse().toString());
    }

    /**
     * Multiplies two binary numbers using binary shift and addition.
     *
     * @param num1 first binary number
     * @param num2 second binary number
     * @return product of the two binary numbers
     */
    public static Binary multiply(Binary num1, Binary num2) {

        if (num1.number.equals("0") || num2.number.equals("0")) {
            return new Binary("0");
        }

        Binary result = new Binary("0");
        int shift = 0;

        // Read the second number from right to left.
        for (int i = num2.number.length() - 1; i >= 0; i--) {

            if (num2.number.charAt(i) == '1') {

                StringBuilder shiftedValue =
                        new StringBuilder(num1.number);

                // A left shift is performed by adding zeros.
                for (int j = 0; j < shift; j++) {
                    shiftedValue.append('0');
                }

                result = add(result,
                        new Binary(shiftedValue.toString()));
            }

            shift++;
        }

        return result;
    }
}