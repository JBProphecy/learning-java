package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Account;

public interface AccountDAI
{
  boolean registerAccount(Account account);
  Account getAccountByID(UUID id);
  boolean updateNameByID(UUID id, String name);
  boolean updateNameByEmail(String email, String name);
  boolean deleteAccountByID(UUID id);
  boolean deleteAccountByEmail(String email);
}
