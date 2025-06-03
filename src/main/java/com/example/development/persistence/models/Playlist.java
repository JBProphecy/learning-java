package com.example.development.persistence.models;

import java.util.List;
import java.util.stream.Collectors;

public class Playlist
{
  // INSTANCE VARIABLES
  private final String id;
  private String name;
  private String description;
  private final List<Song> songs;

  /**
   * private constructor for the Playlist class
   * @param id the id for a playlist
   * @param name the name for a playlist
   * @param description the description for a playlist
   * @param songs the songs for a playlist
   */
  private Playlist(
    String id,
    String name,
    String description,
    List<Song> songs
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.songs = songs;
  }

  /**
   * public constructor to load an existing playlist from the database
   * @param id the id for a playlist
   * @param name the name for a playlist
   * @param description the description for a playlist
   * @param songs the songs for a playlist
   * @return an instance of the Playlist class
   */
  public static Playlist construct(
    String id,
    String name,
    String description,
    List<Song> songs
  ) {
    return new Playlist(id, name, description, songs);
  }

  // GETTER METHODS
  public String getID() { return this.id; }
  public String getName() { return this.name; }
  public String getDescription() { return this.description; }
  public List<Song> getSongs() { return this.songs; }

  @Override
  public String toString() {
    String songNames = this.songs.stream().map(Song::toString).collect(Collectors.joining(", "));
    return
      "Artist{" +
      "id='" + this.id + "', " +
      "name='" + this.name + "', " +
      "artists={" + songNames + "}}"
    ;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) { return true; }
    if (object == null || this.getClass() != object.getClass()) { return false; }
    Playlist playlist = (Playlist) object;
    return this.id.equals(playlist.id);
  }

  @Override
  public int hashCode() { return this.id != null ? id.hashCode() : 0; }

  /**
   * method to add a song to the playlist
   * @param song the song to be added to the playlist
   */
  public void addSong(Song song) {
    this.songs.add(song);
  }

  /**
   * method to get a song from the playlist
   * @param index the index of the song to be retrieved from the playlist
   * @return
   */
  public Song getSong(int index) {
    return this.songs.get(index);
  }

  /**
   * method to remove a song from the playlist
   * @param index the index of the song to be removed from the playlist
   */
  public void removeSong(int index) {
    this.songs.remove(index);
  }
}
