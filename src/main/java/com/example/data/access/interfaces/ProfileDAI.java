package com.example.data.access.interfaces;

import java.util.UUID;

import com.example.data.models.Profile;

public interface ProfileDAI
{
  boolean registerProfile(Profile profile);

  Profile getProfileByID(UUID id);
  
  Profile getProfileByUsername(String username);

  // List<Profile> getProfilesByAccountID(UUID id);

  boolean updateName(UUID id, String name);

  // boolean updateUsername(UUID id, String username);

  // boolean updatePassword(UUID id, String password);

  boolean deleteProfile(UUID id);
}
