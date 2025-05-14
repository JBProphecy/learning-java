package com.example.persistence.services;

import com.example.persistence.access.PostgresAccountDAO;
import com.example.persistence.interfaces.AccountDAI;
import com.example.persistence.models.Account;

public class AccountService {
  private AccountDAI accountDAO;

  public AccountService() {
    this.accountDAO = new PostgresAccountDAO();
  }

  public boolean deleteAccountByEmail(String email) {
    return this.accountDAO.deleteAccountByEmail(email);
  }

  public boolean insertAccount(Account account) {
    return this.accountDAO.insertAccount(account);
  }
}
