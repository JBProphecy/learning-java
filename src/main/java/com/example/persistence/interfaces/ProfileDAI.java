package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Profile;

public interface ProfileDAI
{
  boolean registerProfile(Profile profile);
  Profile getProfileByID(UUID id);
  boolean updateNameByID(UUID id, String name);
  boolean updateNameByUsername(String username, String name);
  boolean deleteProfileByID(UUID id);
  boolean deleteProfileByUsername(String username);
}
