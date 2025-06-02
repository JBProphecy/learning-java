package com.example.data.access.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.data.access.interfaces.PlaylistDAI;
import com.example.data.models.music.Playlist;
import com.example.data.utilities.PostgresConnectionUtility;

public class PostgresPlaylistDAO implements PlaylistDAI
{
  private static final Logger logger = LoggerFactory.getLogger(PostgresAccountDAO.class);

  @Override
  public boolean registerPlaylist(Playlist playlist) { // surely the insert fields are not complete yet
    String sql = """
      INSERT INTO playlists (id, name, description)
      VALUES (?, ?, ?)
      """
    ;
    try (
      Connection connection = PostgresConnectionUtility.getConnection();
      PreparedStatement statement = connection.prepareStatement(sql);
    ) {
      statement.setObject(1, playlist.getID());
      statement.setString(2, playlist.getName());
      statement.setString(3, playlist.getDescription());
      return statement.executeUpdate() > 0;
    }
    catch (SQLException e) {
      logger.error("Error Registering Account", e);
      return false;
    }
  }
}