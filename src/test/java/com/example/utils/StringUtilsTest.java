package com.example.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilsTest
{
  @Test
  public void countVowelsTest_EmptyString()
  {
    String input = "";
    int result = StringUtils.countVowels(input);
    assertEquals(0, result);
  }

  @Test
  public void countVowelsTestOne()
  {
    String input = "I like cookies!";
    int result = StringUtils.countVowels(input);
    assertEquals(7, result);
  }

  @Test
  public void countVowelsTestTwo()
  {
    String input = "TheLegend27";
    int result = StringUtils.countVowels(input);
    assertEquals(3, result);
  }
}
