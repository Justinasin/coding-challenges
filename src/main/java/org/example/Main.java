package org.example;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Bubble sort

        BubbleSort bubbleSort = new BubbleSort();
        int arraySize = 100;

        double[] array = generateDoubleArray(arraySize);

        bubbleSort.sort(array);

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Number: " + array[i]);
        }

        // FibonacciSeries

        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        fibonacciSeries.generateFibonacciSeries(100);

        // Prime number

        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println(primeNumber.isPrimeNumber(8));

        // String Palindrome

        StringPalindrome stringPalindrome = new StringPalindrome();
        System.out.println(
                "Is text: 'abcdefg' a palindrome? " + stringPalindrome.isStringPalindrome("abcdefg"));
        System.out.println(
                "Is text: 'aaa' a palindrome? " + stringPalindrome.isStringPalindrome("aaa"));
        System.out.println(
                "Is text: 'abcba' a palindrome? " + stringPalindrome.isStringPalindrome("abcba"));

        // Integer Palindrome
        IntegerPalindrome integerPalindrome = new IntegerPalindrome();
        System.out.println(
                "Is number: '12345' a palindrome? " + integerPalindrome.isIntegerPalindrome(12345));

        System.out.println(
                "Is number: '123454321' a palindrome? " + integerPalindrome.isIntegerPalindrome(123454321));

        // Integer Palindrome Advanced
        IntegerPalindromeAdvanced integerPalindromeAdvanced = new IntegerPalindromeAdvanced();
        System.out.println(
                "Is number: '123454321' a palindrome? According to advanced calculation - " + integerPalindromeAdvanced.isIntegerPalindrome(
                        123454321));

        System.out.println(
                "Is number: '12587569' a palindrome? According to advanced calculation - " + integerPalindromeAdvanced.isIntegerPalindrome(
                        12587569));


        // DrawSquare

        DrawSquare drawSquare = new DrawSquare();
        System.out.println(drawSquare.temp());

        // Compare files

        CompareFiles compareFiles = new CompareFiles();
        compareFiles.parseDirectory("C:\\filestocompare");

    }

    private static double[] generateDoubleArray(int size) {
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = Math.random() * 100;
        }

        return array;
    }
}
