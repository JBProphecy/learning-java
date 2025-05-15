package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Account;

public interface AccountDAI
{
  boolean registerAccount(Account account);

  Account getAccountByID(UUID id);
  Account getAccountByEmail(String email);

  boolean updateName(UUID id, String name);

  boolean deleteAccount(UUID id);
}
