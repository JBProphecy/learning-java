package com.example.temp.utils;

public class IntegerListUtils
{
  public static int[] combine(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    System.arraycopy(a, 0, c, 0, a.length);
    System.arraycopy(b, 0, c, a.length, b.length);
    return c;
  }

  public static int[] getTopTwo(int[] numbers) {
    if (numbers.length < 2) { throw new IllegalArgumentException("The array must contain at least two elements."); }
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int n : numbers) {
      if (n > max1) { max2 = max1; max1 = n; }
      else if (n > max2) { max2 = n; }
    }
    return new int[] {max1, max2};
  }
}
