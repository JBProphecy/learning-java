package com.example.persistence.service.interfaces;

import com.example.persistence.models.Profile;

public interface ProfileServiceInterface
{
  boolean registerProfile(Profile profile);

  Profile getProfileByID(String id);

  Profile getProfileByUsername(String username);

  boolean updateNameByID(String id, String name);

  boolean deleteProfile(String id);
}
