package com.example.data.service.classes;

import java.util.UUID;

import com.example.data.access.interfaces.AccountDAI;
import com.example.data.models.Account;
import com.example.data.service.interfaces.AccountServiceInterface;

public class AccountServiceObject implements AccountServiceInterface
{
  private final AccountDAI accountDAO;

  public AccountServiceObject(AccountDAI accountDAO) {
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
