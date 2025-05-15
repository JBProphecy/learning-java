package com.example;

import java.util.UUID;

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

    UUID accountID = UUID.fromString("bb952999-e4f0-4901-aad3-e90662044d48");
    UUID profileID = UUID.fromString("3eb06be5-94ac-443e-9af3-770a23c0bc9d");

    // Delete Profile
    System.out.println("Deleted Profile: " + profileService.deleteProfile(profileID));

    // Delete Account
    System.out.println("Deleted Account: " + accountService.deleteAccount(accountID));

    // Create Account
    Account account = Account.construct(accountID, "Jack", "hey@gmail.com", "hey");

    // Register Account
    System.out.println("Registered Account: " + accountService.registerAccount(account));

    // Get Account
    Account registeredAccount = accountService.getAccountByID(account.getID());

    // Create Profile
    Profile profile = Profile.construct(profileID, "Jack", "YoDaMcSteamy", "bitch", registeredAccount.getID());

    // Register Profile
    System.out.println("Registered Profile: " + profileService.registerProfile(profile));
  }
}
