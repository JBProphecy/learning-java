CREATE TABLE general_folder_general_folders (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_general_folders_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_general_folders_parent_id_fkey
    FOREIGN KEY (parent_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_general_folders_child_id_fkey
    FOREIGN KEY (child_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_single_folders (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_single_folders_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_single_folders_parent_id_fkey
    FOREIGN KEY (parent_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_single_folders_child_id_fkey
    FOREIGN KEY (child_id)
    REFERENCES single_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_album_folders (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_album_folders_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_album_folders_parent_id_fkey
    FOREIGN KEY (parent_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_album_folders_child_id_fkey
    FOREIGN KEY (child_id)
    REFERENCES album_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_playlist_folders (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_playlist_folders_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_playlist_folders_parent_id_fkey
    FOREIGN KEY (parent_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_playlist_folders_child_id_fkey
    FOREIGN KEY (child_id)
    REFERENCES playlist_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_label_folders (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_label_folders_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_label_folders_parent_id_fkey
    FOREIGN KEY (parent_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_label_folders_child_id_fkey
    FOREIGN KEY (child_id)
    REFERENCES label_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_singles (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_singles_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_singles_parent_id_fkey
    FOREIGN KEY (folder_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_singles_child_id_fkey
    FOREIGN KEY singles (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_albums (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_albums_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_albums_parent_id_fkey
    FOREIGN KEY (folder_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_albums_child_id_fkey
    FOREIGN KEY albums (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_playlists (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_playlists_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_playlists_parent_id_fkey
    FOREIGN KEY (folder_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_playlists_child_id_fkey
    FOREIGN KEY playlists (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);

CREATE TABLE general_folder_labels (
  parent_id text NOT NULL,
  child_id text NOT NULL,

  CONSTRAINT general_folder_labels_pkey PRIMARY KEY (parent_id, child_id);

  CONSTRAINT general_folder_labels_parent_id_fkey
    FOREIGN KEY (folder_id)
    REFERENCES general_folders (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE,
  
  CONSTRAINT general_folder_labels_child_id_fkey
    FOREIGN KEY labels (id)
      ON UPDATE NO ACTION
      ON DELETE CASCADE
);