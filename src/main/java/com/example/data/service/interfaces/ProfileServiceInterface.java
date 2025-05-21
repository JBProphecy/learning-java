package com.example.data.service.interfaces;

import java.util.UUID;

import com.example.data.models.Profile;

public interface ProfileServiceInterface
{
  boolean registerProfile(Profile profile);

  Profile getProfileByID(UUID id);

  Profile getProfileByUsername(String username);

  boolean updateNameByID(UUID id, String name);

  boolean deleteProfile(UUID id);
}
