package com.example.data.access.interfaces;

import java.util.UUID;

import com.example.data.models.music.Playlist;

public interface PlaylistDAI
{
  boolean registerPlaylist(Playlist playlist);

  Playlist getPlaylistByID(UUID id);

  boolean updatePlaylistByID(UUID id);

  boolean deletePlaylistByID(UUID id);
}
