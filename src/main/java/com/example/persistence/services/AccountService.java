package com.example.persistence.services;

import java.util.UUID;

import com.example.persistence.interfaces.AccountDAI;
import com.example.persistence.models.Account;

public class AccountService
{
  private final AccountDAI accountDAO;

  public AccountService(AccountDAI accountDAO) {
    this.accountDAO = accountDAO;
  }

  public boolean registerAccount(Account account) {
    return this.accountDAO.registerAccount(account);
  }

  public Account getAccountByID(UUID id) {
    return this.accountDAO.getAccountByID(id);
  }

  public Account getAccountByEmail(String email) {
    return this.accountDAO.getAccountByEmail(email);
  }

  public boolean updateName(UUID id, String name) {
    return this.accountDAO.updateName(id, name);
  }

  public boolean deleteAccount(UUID id) {
    return this.accountDAO.deleteAccount(id);
  }
}
