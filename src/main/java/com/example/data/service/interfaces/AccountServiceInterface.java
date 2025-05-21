package com.example.data.service.interfaces;

import java.util.UUID;

import com.example.data.models.Account;

public interface AccountServiceInterface
{
  boolean registerAccount(Account account);

  Account getAccountByID(UUID id);

  Account getAccountByEmail(String email);

  boolean updateName(UUID id, String name);

  boolean deleteAccount(UUID id);
}
