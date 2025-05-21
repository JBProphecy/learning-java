package com.example.data.service.classes;

import java.util.UUID;

import com.example.data.access.interfaces.ProfileDAI;
import com.example.data.models.Profile;
import com.example.data.service.interfaces.ProfileServiceInterface;

public class ProfileServiceObject implements ProfileServiceInterface
{
  private final ProfileDAI profileDAO;

  public ProfileServiceObject(ProfileDAI profileDAO) {
    this.profileDAO = profileDAO;
  }
  
  public boolean registerProfile(Profile profile) {
    return this.profileDAO.registerProfile(profile);
  }

  public Profile getProfileByID(UUID id) {
    return this.profileDAO.getProfileByID(id);
  }

  public Profile getProfileByUsername(String username) {
    return this.profileDAO.getProfileByUsername(username);
  }

  public boolean updateNameByID(UUID id, String name) {
    return this.profileDAO.updateName(id, name);
  }

  public boolean deleteProfile(UUID id) {
    return this.profileDAO.deleteProfile(id);
  }
}
