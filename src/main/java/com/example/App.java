package com.example;

import com.example.persistence.models.Account;
import com.example.persistence.services.AccountService;

public class App {
  public static void main(String[] args)
  {
    System.out.println("Hello World");

    // Create Account
    Account account = new Account("Jack", "hey@gmail.com", "hey");
    System.out.println("Created Account: " + account);

    // Account Service
    AccountService accountService = new AccountService();

    // Register Account
    System.out.println("Registered Account: " + accountService.registerAccount(account));

    // Delete Account
    System.out.println("Deleted Account by Email: " + accountService.deleteAccountByEmail("hey@gmail.com"));
  }
}
