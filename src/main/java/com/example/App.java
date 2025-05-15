package com.example;

import com.example.persistence.access.PostgresAccountDAO;
import com.example.persistence.access.PostgresProfileDAO;
import com.example.persistence.models.Account;
import com.example.persistence.models.Profile;
import com.example.persistence.services.AccountService;
import com.example.persistence.services.ProfileService;

public class App {
  public static void main(String[] args)
  {
    System.out.println("Hello World");

    // Services
    AccountService accountService = new AccountService(new PostgresAccountDAO());
    ProfileService profileService = new ProfileService(new PostgresProfileDAO());

    // Create Account
    Account account = Account.generate("Jack", "hey@gmail.com", "hey");
    System.out.println("Created Account: " + account);

    // Register Account
    System.out.println("Registered Account: " + accountService.registerAccount(account));

    // Get Account
    Account registeredAccount = accountService.getAccountByEmail("hey@gmail.com");

    // Create Profile
    Profile profile = Profile.generate("Jack", "YoDaMcSteamy", "bitch", registeredAccount.getID());
    System.out.println("Created Profile: " + profile);

    // Register Profile
    System.out.println("Registered Profile: " + profileService.registerProfile(profile));
  }
}
