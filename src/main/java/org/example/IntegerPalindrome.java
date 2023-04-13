package org.example;

public class IntegerPalindrome {

  public boolean isIntegerPalindrome(int number) {

    return number == Integer.parseInt(reverseInteger(String.valueOf(number)));
  }

  private String reverseInteger(String number) {

    if(number.isEmpty()) {
      return number;
    }

    return number.charAt(number.length() - 1)
        + reverseInteger(
        number.substring(0, number.length() - 1));
  }
}
