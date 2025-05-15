package com.example.persistence.services;

import java.util.UUID;

import com.example.persistence.access.PostgresAccountDAO;
import com.example.persistence.interfaces.AccountDAI;
import com.example.persistence.models.Account;

public class AccountService {
  private AccountDAI accountDAO;

  public AccountService() {
    this.accountDAO = new PostgresAccountDAO();
  }

  public boolean registerAccount(Account account) {
    return this.accountDAO.registerAccount(account);
  }

  public Account getAccountByID(UUID id) {
    return this.accountDAO.getAccountByID(id);
  }

  public boolean updateNameByID(UUID id, String name) {
    return this.accountDAO.updateNameByID(id, name);
  }

  public boolean updateNameByEmail(String email, String name) {
    return this.accountDAO.updateNameByEmail(email, name);
  }

  public boolean deleteAccountByID(UUID id) {
    return this.accountDAO.deleteAccountByID(id);
  }

  public boolean deleteAccountByEmail(String email) {
    return this.accountDAO.deleteAccountByEmail(email);
  }
}
