package com.example.data.models.music;

import java.util.List;
import java.util.UUID;

public class Album
{
  // Instance Variables
  private final UUID id;
  private String title;
  private String description;
  private List<Song> songs;

  private Album(
    UUID id,
    String title,
    String description,
    List<Song> songs
  ) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.songs = songs;
  }
}
