package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Account;

public interface AccountDAI
{
  // Create
  boolean registerAccount(Account account);

  // Read
  Account getAccountByID(UUID id);

  // Update
  boolean updateNameByID(UUID id, String name);
  boolean updateNameByEmail(String email, String name);

  // Delete
  boolean deleteAccountByID(UUID id);
  boolean deleteAccountByEmail(String email);
}
