package com.example.persistence.services;

import java.util.UUID;

import com.example.persistence.access.PostgresProfileDAO;
import com.example.persistence.interfaces.ProfileDAI;
import com.example.persistence.models.Profile;

public class ProfileService
{
  private ProfileDAI profileDAO;

  public ProfileService() {
    this.profileDAO = new PostgresProfileDAO();
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
