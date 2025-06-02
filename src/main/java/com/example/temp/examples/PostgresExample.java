package com.example.temp.examples;

import java.util.UUID;

import com.example.data.access.classes.PostgresAccountDAO;
import com.example.data.access.classes.PostgresProfileDAO;
import com.example.data.models.Account;
import com.example.data.models.Profile;
import com.example.data.service.classes.AccountServiceObject;
import com.example.data.service.classes.ProfileServiceObject;

public class PostgresExample {
  public static void main() {
    // Services
    AccountServiceObject accountServiceObject = new AccountServiceObject(new PostgresAccountDAO());
    ProfileServiceObject profileServiceObject = new ProfileServiceObject(new PostgresProfileDAO());

    UUID accountID = UUID.fromString("bb952999-e4f0-4901-aad3-e90662044d48");
    UUID profileID = UUID.fromString("3eb06be5-94ac-443e-9af3-770a23c0bc9d");
    UUID profileID2 = UUID.fromString("88888888-94ac-443e-9af3-770a23c0bc9d");

    // Delete Profile
    System.out.println("Deleted Profile: " + profileServiceObject.deleteProfile(profileID));
    System.out.println("Deleted Profile: " + profileServiceObject.deleteProfile(profileID2));

    // Delete Account
    System.out.println("Deleted Account: " + accountServiceObject.deleteAccount(accountID));

    // Create Account
    Account account = Account.construct(accountID, "Jack", "hey@gmail.com", "hey");

    // Register Account
    System.out.println("Registered Account: " + accountServiceObject.registerAccount(account));

    // Get Account
    Account registeredAccount = accountServiceObject.getAccountByID(account.getID());

    // Create Profile
    Profile profile = Profile.construct(profileID, "Jack", "YoDaMcSteamy", "bitch", registeredAccount.getID());
    Profile profile2 = Profile.construct(profileID2, "Kyle", "gangstachickens", "boy", registeredAccount.getID());

    // Register Profile
    System.out.println("Registered Profile: " + profileServiceObject.registerProfile(profile));
    System.out.println("Registered Profile: " + profileServiceObject.registerProfile(profile2));
  }
}
