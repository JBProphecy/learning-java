package com.example.persistence.interfaces;

import com.example.persistence.models.Account;

public interface AccountDAI {
  boolean insertAccount(Account account);
  boolean deleteAccountByEmail(String email);
}
