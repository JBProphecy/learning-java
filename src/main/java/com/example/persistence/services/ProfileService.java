package com.example.persistence.services;

import java.util.UUID;

import com.example.persistence.access.PostgresProfileDAO;
import com.example.persistence.interfaces.ProfileDAI;
import com.example.persistence.models.Profile;

public class ProfileService {
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

  public boolean updateNameByID(UUID id, String name) {
    return this.profileDAO.updateNameByID(id, name);
  }

  public boolean updateNameByUsername(String username, String name) {
    return this.profileDAO.updateNameByUsername(username, name);
  }

  public boolean deleteProfileByID(UUID id) {
    return this.profileDAO.deleteProfileByID(id);
  }

  public boolean deleteProfileByUsername(String username) {
    return this.profileDAO.deleteProfileByUsername(username);
  }
}
