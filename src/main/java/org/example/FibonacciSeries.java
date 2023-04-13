package org.example;

public class FibonacciSeries {

  public void generateFibonacciSeries(int number) {

    int firstNumber;
    int secondNumber = 1;

    int sum = 1;

    while (sum < number) {

      System.out.println("Number: " + sum);

      firstNumber = secondNumber;
      secondNumber = sum;

      sum = firstNumber + secondNumber;
    }
  }

}
