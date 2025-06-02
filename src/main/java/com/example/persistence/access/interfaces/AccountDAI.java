package com.example.persistence.access.interfaces;

import com.example.persistence.models.Account;

public interface AccountDAI
{
  boolean registerAccount(Account account);

  Account getAccountByID(String id);
  
  Account getAccountByEmail(String email);

  boolean updateName(String id, String name);

  boolean deleteAccount(String id);
}
