package org.example;

public class BubbleSort {

  public void sort(double[] array) {

    int n = array.length;

    while (n > 0) {
      for (int i = 0; i < n - 1; i++) {
        if (array[i] > array[i + 1]) {
          double temp = array[i];

          array[i] = array[i + 1];
          array[i + 1] = temp;
        }
      }

      n--;
    }
  }
}
