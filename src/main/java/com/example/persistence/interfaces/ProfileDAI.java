package com.example.persistence.interfaces;

import java.util.UUID;

import com.example.persistence.models.Profile;

public interface ProfileDAI
{
  // Create
  boolean registerProfile(Profile profile);

  // Read
  Profile getProfileByID(UUID id);

  // Update
  boolean updateNameByID(UUID id, String name);
  boolean updateNameByUsername(String username, String name);

  // Delete
  boolean deleteProfileByID(UUID id);
  boolean deleteProfileByUsername(String username);
}
