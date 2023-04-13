package org.example;

public class IntegerPalindromeAdvanced {

  public boolean isIntegerPalindrome(int number) {

    int palindrome = number;
    int reversed = 0;

    while (palindrome != 0) {
      int remainder = palindrome % 10;
      reversed = reversed * 10 + remainder;

      palindrome = palindrome / 10;
    }

    return number == reversed;
  }
}
