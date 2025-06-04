package com.example.temp.Examples;

import com.example.utils.FileUtility;

public class FileUtilityExample {
  public static void main() {
    String sql = FileUtility.getString("sql/v02/tables/folders", "general_folder_items.sql");
    System.out.println(sql);
  }
}
