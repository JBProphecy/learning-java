package com.example.data.models.music.interfaces;

import com.example.data.models.music.Song;

public interface SongCollection
{
  void addSong(Song song);
  Song getSong(int index);
  void removeSong(int index);
}
