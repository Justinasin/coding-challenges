package org.example;

public class PrimeNumber {

  public boolean isPrimeNumber(int number) {
    int halfNumber = number / 2;
    boolean primeNumber = true;

    if (number == 0) {
      System.out.println(
          "Zero is neither prime nor composite. Since any number times zero equals zero, "
              + "there are an infinite number of factors for a product of zero. "
              + "A composite number must have a finite number of factors");

      return false;
    }

    if (halfNumber >= 2) {
      for (int i = 2; i <= halfNumber; i++) {
        if (number % halfNumber == 0) {
          primeNumber = false;
          break;
        }
      }
    }

    return primeNumber;
  }
}
