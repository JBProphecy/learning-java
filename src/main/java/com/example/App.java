package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.data.models.music.Artist;
import com.example.data.models.music.Song;

public class App
{
  public static void main(String[] args)
  {
    Artist artist01 = Artist.construct(UUID.randomUUID(), "Jack", "YoDaMcSteamy");
    Artist artist02 = Artist.construct(UUID.randomUUID(), "Kyle", "gangstachickens");
    Artist artist03 = Artist.construct(UUID.randomUUID(), "Todd", "pigribs");
    Set<Artist> artists01 = new HashSet<Artist>();
    artists01.add(artist01);
    artists01.add(artist02);
    Song song01 = Song.construct(UUID.randomUUID(), "Z4 Music", artists01, null, null);
    System.out.println("ARTIST EXAMPLE STRING");
    System.out.println(artist03);
    System.out.println("SONG EXAMPLE STRING");
    System.out.println(song01);
  }
}
