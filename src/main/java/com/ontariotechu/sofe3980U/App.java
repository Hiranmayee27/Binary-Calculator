package com.ontariotechu.sofe3980U;

/**
 * Demonstrates binary arithmetic and logical operations.
 */
public class App {

    /**
     * Main program.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {

        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");

        Binary sum = Binary.add(binary1, binary2);
        Binary orResult = Binary.or(binary1, binary2);
        Binary andResult = Binary.and(binary1, binary2);
        Binary product = Binary.multiply(binary1, binary2);

        System.out.println(
                "First binary number is " + binary1.getValue());

        System.out.println(
                "Second binary number is " + binary2.getValue());

        System.out.println(
                "Their summation is " + sum.getValue());

        System.out.println(
                "Their bitwise OR is " + orResult.getValue());

        System.out.println(
                "Their bitwise AND is " + andResult.getValue());

        System.out.println(
                "Their multiplication is " + product.getValue());
    }
}