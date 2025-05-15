package com.example;

import com.example.persistence.models.Account;
import com.example.persistence.models.Profile;
import com.example.persistence.services.AccountService;
import com.example.persistence.services.ProfileService;

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

    // Get Account
    Account registeredAccount = accountService.getAccountByEmail("hey@gmail.com");

    // Create Profile
    Profile profile = new Profile("Jack", "YoDaMcSteamy", "bitch", registeredAccount.getID());
    System.out.println("Created Profile: " + profile);
    // Profile Service
    ProfileService profileService = new ProfileService();
    // Register Profile
    System.out.println("Registered Profile: " + profileService.registerProfile(profile));
    // Delete Profile
  }
}
