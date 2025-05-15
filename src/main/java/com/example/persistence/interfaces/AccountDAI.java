package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Account;

public interface AccountDAI
{
  // CREATE
  boolean registerAccount(Account account);

  // READ
  Account getAccountByID(UUID id);
  Account getAccountByEmail(String email);

  // UPDATE
  boolean updateName(UUID id, String name);

  // DELETE
  boolean deleteAccount(UUID id);
}
