package org.example;

public class StringPalindrome {

  public boolean isStringPalindrome(String text) {
    if (text == null) {
      System.out.println("Text cannot be null");

      return false;
    }

    return text.equals(reverseString(text));
  }

  private String reverseString(String text) {
    if (text == null || text.isEmpty()) {
      return text;
    }

    return text.charAt(text.length() - 1) + reverseString(text.substring(0, text.length() - 1));
  }
}
