package com.example.temp.utils;

import java.util.HashMap;
import java.util.Map;

public final class StringUtils
{
  public static int countVowels(String input) {
    int count = 0;
    for (char c : input.toLowerCase().toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { count++; }
    }
    return count;
  }

  public static boolean isPalindrome(String str) {
    int n = str.length();
    for (int i = 0; i < n / 2; i++) {
      if (str.charAt(i) != str.charAt(n - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static Map<String, Integer> generateWordCountMap(String text) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String word : text.split(" ")) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }
    return map;
  }
}
