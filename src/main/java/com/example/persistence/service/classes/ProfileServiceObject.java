package com.example.persistence.service.classes;

import com.example.persistence.access.interfaces.ProfileDAI;
import com.example.persistence.models.Profile;
import com.example.persistence.service.interfaces.ProfileServiceInterface;

public class ProfileServiceObject implements ProfileServiceInterface
{
  private final ProfileDAI profileDAO;

  public ProfileServiceObject(ProfileDAI profileDAO) {
    this.profileDAO = profileDAO;
  }
  
  public boolean registerProfile(Profile profile) {
    return this.profileDAO.registerProfile(profile);
  }

  public Profile getProfileByID(String id) {
    return this.profileDAO.getProfileByID(id);
  }

  public Profile getProfileByUsername(String username) {
    return this.profileDAO.getProfileByUsername(username);
  }

  public boolean updateNameByID(String id, String name) {
    return this.profileDAO.updateName(id, name);
  }

  public boolean deleteProfile(String id) {
    return this.profileDAO.deleteProfile(id);
  }
}
