package com.example;

import com.example.persistence.access.PostgresAccountDAO;
import com.example.persistence.models.Account;

public class App
{
  public static void main(String[] args)
  {
    System.out.println("Hello World");

    // Account DAO
    PostgresAccountDAO manager = new PostgresAccountDAO();

    // Create Account
    Account account = new Account("1", "Jack", "hey@gmail.com", "hey");
    System.out.println("Created Account: " + manager.insertAccount(account));

    // Delete Account
    System.out.println("Deleted Account: " + manager.deleteAccountByEmail("hey@gmail.com"));
  }
}
