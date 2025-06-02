CREATE TABLE track_artists (
	track_id text NOT NULL,
	profile_id text NOT NULL,
	CONSTRAINT track_artists_pkey PRIMARY KEY (track_id, profile_id),
	CONSTRAINT track_artists_track_id_fkey FOREIGN KEY (track_id)
		REFERENCES tracks (id),
	CONSTRAINT track_artists_profile_id_fkey FOREIGN KEY (profile_id)
		REFERENCES profiles (id)
);

CREATE TABLE single_artists (
	single_id text NOT NULL,
	profile_id text NOT NULL,
	CONSTRAINT single_artists_pkey PRIMARY KEY (single_id, profile_id),
	CONSTRAINT single_artists_single_id_fkey FOREIGN KEY (single_id)
		REFERENCES singles (id),
	CONSTRAINT single_artists_profile_id_fkey FOREIGN KEY (profile_id)
		REFERENCES profiles (id)
);

CREATE TABLE album_artists (
	album_id text NOT NULL,
	profile_id text NOT NULL,
	CONSTRAINT album_artists_pkey PRIMARY KEY (album_id, profile_id),
	CONSTRAINT album_artists_album_id_fkey FOREIGN KEY (album_id)
		REFERENCES albums (id),
	CONSTRAINT album_artists_profile_id_fkey FOREIGN KEY (profile_id)
		REFERENCES profiles (id)
);

CREATE TABLE playlist_artists (
	playlist_id text NOT NULL,
	profile_id text NOT NULL,
	CONSTRAINT playlist_artists_pkey PRIMARY KEY (playlist_id, profile_id),
	CONSTRAINT playlist_artists_playlist_id_fkey FOREIGN KEY (playlist_id)
		REFERENCES playlists (id),
	CONSTRAINT playlist_artists_profile_id_fkey FOREIGN KEY (profile_id)
		REFERENCES profiles (id)
);

CREATE TABLE label_artists (
	label_id text NOT NULL,
	profile_id text NOT NULL,
	CONSTRAINT label_artists_pkey PRIMARY KEY (label_id, profile_id),
	CONSTRAINT label_artists_label_id_fkey FOREIGN KEY (label_id)
		REFERENCES labels (id),
	CONSTRAINT label_artists_profile_id_fkey FOREIGN KEY (profile_id)
		REFERENCES profiles (id)
);
