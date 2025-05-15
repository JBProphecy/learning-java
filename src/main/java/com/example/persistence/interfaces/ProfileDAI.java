package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Profile;

public interface ProfileDAI
{
  // CREATE
  boolean registerProfile(Profile profile);

  // READ
  Profile getProfileByID(UUID id);
  Profile getProfileByUsername(String username);
  // List<Profile> getProfilesByAccountID(UUID id);

  // UPDATE
  boolean updateName(UUID id, String name);
  // boolean updateUsername(UUID id, String username);
  // boolean updatePassword(UUID id, String password);

  // DELETE
  boolean deleteProfile(UUID id);
}
