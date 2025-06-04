package com.example.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {
  public static String getString(String path, String file) {
    try {
      return Files.readString(Paths.get(path, file), StandardCharsets.UTF_8);
    }
    catch (IOException e) {
      System.err.println("Failed to Read File: " + e.getMessage());
      return "";
    }
  }
}
