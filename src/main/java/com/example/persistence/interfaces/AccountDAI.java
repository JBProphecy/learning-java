package com.example.persistence.interfaces;

import com.example.persistence.models.Account;

public interface AccountDAI {
  boolean changeNameByID(String id, String name);
  boolean changeNameByEmail(String email, String name);
  boolean insertAccount(Account account);
  boolean deleteAccountByEmail(String email);
}
