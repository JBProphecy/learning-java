package com.example.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.example.temp.utils.IntegerListUtils;

public class IntegerListUtilsTest
{
  @Test
  public void combine_Test01()
  {
    int[] a = new int[0];
    int[] b = new int[0];
    int[] actualResult = IntegerListUtils.combine(a, b);
    int[] expectedResult = new int[0];
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void combine_Test02()
  {
    int[] a = new int[] {1, 2, 3};
    int[] b = new int[] {4, 5, 6, 7, 8};
    int[] actualResult = IntegerListUtils.combine(a, b);
    int[] expectedResult = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  public void getTopTwo_EmptyArray_Throws()
  {
    int[] numbers = new int[0];
    Executable executable = () -> IntegerListUtils.getTopTwo(numbers);
    assertThrows(IllegalArgumentException.class, executable);
  }

  @Test
  public void getTopTwo_OneElement_Throws()
  {
    int[] numbers = new int[1];
    Executable executable = () -> IntegerListUtils.getTopTwo(numbers);
    assertThrows(IllegalArgumentException.class, executable);
  }

  @Test
  public void getTopTwo_TwoElementsTest01_Returns()
  {
    int[] numbers = new int[2];
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {0, 0};
    assertArrayEquals(expected, result);
  }

  @Test
  public void getTopTwo_TwoElementsTest02_Returns()
  {
    int[] numbers = new int[] {4, 5};
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {5, 4};
    assertArrayEquals(expected, result);
  }

  @Test
  public void getTopTwo_TwoElementsTest03_Returns()
  {
    int[] numbers = new int[] {5, 4};
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {5, 4};
    assertArrayEquals(expected, result);
  }

  @Test
  public void getTopTwo_ManyElementsTest01_Returns()
  {
    int[] numbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {9, 8};
    assertArrayEquals(expected, result);
  }

  @Test
  public void getTopTwo_ManyElementsTest02_Returns()
  {
    int[] numbers = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {9, 8};
    assertArrayEquals(expected, result);
  }

  @Test
  public void getTopTwo_ManyElementsTest03_Returns()
  {
    int[] numbers = new int[] {2, 6, 4, 9, 1, 3, 0, 7, 5, 8};
    int[] result = IntegerListUtils.getTopTwo(numbers);
    int[] expected = new int[] {9, 8};
    assertArrayEquals(expected, result);
  }
}
