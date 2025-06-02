package com.example.persistence.access.interfaces;

import com.example.persistence.models.Profile;

public interface ProfileDAI
{
  boolean registerProfile(Profile profile);

  Profile getProfileByID(String id);
  
  Profile getProfileByUsername(String username);

  // List<Profile> getProfilesByAccountID(String id);

  boolean updateName(String id, String name);

  // boolean updateUsername(String id, String username);

  // boolean updatePassword(String id, String password);

  boolean deleteProfile(String id);
}
