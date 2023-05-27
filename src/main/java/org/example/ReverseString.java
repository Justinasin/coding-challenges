package org.example;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String text) {
        if (text.length() <= 1) {
            return text;
        }

        // Method with STACK
        Stack<Character> textStack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            textStack.push(text.charAt(i));
        }

        StringBuilder reversedStrBuilder = new StringBuilder();
        for (int i = textStack.size(); i >= 1; i--) {
            reversedStrBuilder.append(textStack.pop());
        }

        return reversedStrBuilder.toString();

        // Method with StringBuilder

        //        StringBuilder stringBuilder = new StringBuilder();
        //        for (int i = text.length() - 1; i >= 0; i--) {
        //            stringBuilder.append(text.charAt(i));
        //        }
        //
        //        return stringBuilder.toString();
    }
}
