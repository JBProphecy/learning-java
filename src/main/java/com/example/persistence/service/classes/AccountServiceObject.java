package com.example.persistence.service.classes;

import com.example.persistence.access.interfaces.AccountDAI;
import com.example.persistence.models.Account;
import com.example.persistence.service.interfaces.AccountServiceInterface;

public class AccountServiceObject implements AccountServiceInterface
{
  private final AccountDAI accountDAO;

  public AccountServiceObject(AccountDAI accountDAO) {
    this.accountDAO = accountDAO;
  }

  public boolean registerAccount(Account account) {
    return this.accountDAO.registerAccount(account);
  }

  public Account getAccountByID(String id) {
    return this.accountDAO.getAccountByID(id);
  }

  public Account getAccountByEmail(String email) {
    return this.accountDAO.getAccountByEmail(email);
  }

  public boolean updateName(String id, String name) {
    return this.accountDAO.updateName(id, name);
  }

  public boolean deleteAccount(String id) {
    return this.accountDAO.deleteAccount(id);
  }
}
