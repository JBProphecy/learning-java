package com.example.temp.utils;

public final class StringUtils
{
  public static int countVowels(String input) {
    int count = 0;
    for (char c : input.toLowerCase().toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { count++; }
    }
    return count;
  }
}
