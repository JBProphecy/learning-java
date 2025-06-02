package com.example.data.models.music;

import java.net.URI;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Song
{
  // Intance Variables
  private final UUID id;
  private final String title;
  private final Set<Artist> artists;
  private final URI audio;
  private final URI cover;

  /**
   * private constructor for the Song class
   * @param id the id of a song
   * @param title the title of a song
   * @param artists the artists of a song
   * @param audio the audio of a song
   * @param cover the cover of a song
   */
  private Song(
    UUID id,
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
   * public constructor for an existing song
   * @param id the id of a song
   * @param title the title of a song
   * @param artists the artists of a song
   * @param audio the audio of a song
   * @param cover the cover of a song
   * @return an instance of the Song class
   */
  public static Song construct(
    UUID id,
    String title,
    Set<Artist> artists,
    URI audio,
    URI cover
  ) {
    return new Song(id, title, artists, audio, cover);
  }

  // Getter Methods
  public UUID getID() { return this.id; }
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
