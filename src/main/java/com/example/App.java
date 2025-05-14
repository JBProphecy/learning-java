package com.example;

import com.example.persistence.models.Account;
import com.example.persistence.services.AccountService;

import io.javalin.Javalin;

public class App
{
  public static void main(String[] args)
  {
    System.out.println("Hello World");

    // Account Service
    AccountService accountService = new AccountService();

    // Create Account
    Account account = new Account("1", "Jack", "hey@gmail.com", "hey");
    System.out.println("Created Account: " + accountService.insertAccount(account));

    // Delete Account
    System.out.println("Deleted Account: " + accountService.deleteAccountByEmail("hey@gmail.com"));

    // Web Server
    Javalin app = Javalin.create().start(9000);
  }
}
