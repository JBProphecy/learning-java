package com.example.development.persistence.models;

import java.net.URI;
import java.util.Set;
import java.util.stream.Collectors;

public class Song
{
  // INSTANCE VARIABLES
  private final String id;
  private final String title;
  private final Set<Artist> artists;
  private final URI audio;
  private final URI cover;

  /**
   * private constructor for the Song class
   * @param id the id for a song
   * @param title the title for a song
   * @param artists the artists for a song
   * @param audio the audio for a song
   * @param cover the cover for a song
   */
  private Song(
    String id,
    String title,
    Set<Artist> artists,
    URI audio,
    URI cover
  ) {
    this.id = id;
    this.title = title;
    this.artists = artists;
    this.audio = audio;
    this.cover = cover;
  }

  /**
   * public constructor to load an existing song from the database
   * @param id the id for a song
   * @param title the title for a song
   * @param artists the artists for a song
   * @param audio the audio for a song
   * @param cover the cover for a song
   * @return an instance of the Song class
   */
  public static Song construct(
    String id,
    String title,
    Set<Artist> artists,
    URI audio,
    URI cover
  ) {
    return new Song(id, title, artists, audio, cover);
  }

  // GETTER METHODS
  public String getID() { return this.id; }
  public String getTitle() { return this.title; }
  public Set<Artist> getArtists() { return this.artists; }
  public URI getAudio() { return this.audio; }
  public URI getCover() { return this.cover; }

  @Override
  public String toString() {
    String artistNames = this.artists.stream().map(Artist::toString).collect(Collectors.joining(", "));
    boolean hasAudio = this.audio != null;
    boolean hasCover = this.cover != null;
    return
      "Song{" +
      "id='" + this.id + "', " +
      "title='" + this.title + "', " +
      "artists={" + artistNames + ", " +
      "audio?=" + hasAudio + ", " +
      "cover?=" + hasCover + "}"
    ;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) { return true; }
    if (object == null || this.getClass() != object.getClass()) { return false; }
    Song song = (Song) object;
    return this.id.equals(song.id);
  }

  @Override
  public int hashCode() { return this.id != null ? id.hashCode() : 0; }
}
