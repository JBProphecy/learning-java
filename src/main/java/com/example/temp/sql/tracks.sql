CREATE TABLE single_tracks (
  single_id text NOT NULL,
  track_id text NOT NULL,
	track_number integer NOT NULL,
  CONSTRAINT single_tracks_pkey PRIMARY KEY (single_id, track_id),
  CONSTRAINT single_tracks_track_id_key UNIQUE (track_id),
	CONSTRAINT single_tracks_single_id_track_number_key UNIQUE (single_id, track_number),
  CONSTRAINT single_tracks_single_id_fkey FOREIGN KEY (single_id)
    REFERENCES singles (id),
  CONSTRAINT single_tracks_track_id_fkey FOREIGN KEY (track_id)
    REFERENCES tracks (id)
);

CREATE TABLE album_tracks (
	album_id text NOT NULL,
	track_id text NOT NULL,
	track_number integer NOT NULL,
	CONSTRAINT album_tracks_pkey PRIMARY KEY (album_id, track_id),
  CONSTRAINT album_tracks_track_id_key UNIQUE (track_id),
	CONSTRAINT album_tracks_album_id_track_number_key UNIQUE (album_id, track_number),
	CONSTRAINT album_tracks_album_id_fkey FOREIGN KEY (album_id)
		REFERENCES albums (id),
	CONSTRAINT album_tracks_track_id_fkey FOREIGN KEY (track_id)
		REFERENCES tracks (id)
);

CREATE TABLE playlist_tracks (
	playlist_id text NOT NULL,
	track_id text NOT NULL,
	track_number integer NOT NULL,
	CONSTRAINT playlist_tracks_pkey PRIMARY KEY (playlist_id, track_id),
	CONSTRAINT playlist_tracks_playlist_id_track_number_key UNIQUE (playlist_id, track_number),
	CONSTRAINT playlist_tracks_playlist_id_fkey FOREIGN KEY (playlist_id)
		REFERENCES playlists (id),
	CONSTRAINT playlist_tracks_track_id_fkey FOREIGN KEY (track_id)
		REFERENCES tracks (id)
);

CREATE TABLE label_tracks (
	label_id text NOT NULL,
	track_id text NOT NULL,
	track_number integer NOT NULL,
	CONSTRAINT label_tracks_pkey PRIMARY KEY (label_id, track_id),
	CONSTRAINT label_tracks_label_id_track_number_key UNIQUE (label_id, track_number),
	CONSTRAINT label_tracks_label_id_fkey FOREIGN KEY (label_id)
		REFERENCES labels (id),
	CONSTRAINT label_tracks_track_id_fkey FOREIGN KEY (track_id)
		REFERENCES tracks (id)
);