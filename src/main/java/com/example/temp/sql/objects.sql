CREATE TABLE accounts (
	id text NOT NULL,
	name text NOT NULL,
	email text NOT NULL,
	password text NOT NULL,
	CONSTRAINT accounts_pkey PRIMARY KEY (id),
	CONSTRAINT accounts_email_key UNIQUE (email)
);

CREATE TABLE profiles (
	id text NOT NULL,
	name text NOT NULL,
	username text NOT NULL,
	password text NOT NULL,
	account_id text NOT NULL,
	profile_picture_url text,
	CONSTRAINT profiles_pkey PRIMARY KEY (id),
	CONSTRAINT profiles_username_key UNIQUE (username),
	CONSTRAINT profiles_account_id_fkey FOREIGN KEY (account_id)
		REFERENCES accounts (id)
			ON UPDATE DELETE
			ON DELETE CASCADE
);

CREATE TABLE tracks (
	id text NOT NULL,
	name text NOT NULL,
	collection_id text NOT NULL,
	collection_type releasable_collection NOT NULL,
	CONSTRAINT tracks_pkey PRIMARY KEY (id),
);

CREATE TABLE singles (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	release_date date NOT NULL,
	CONTRAINT singles_pkey PRIMARY KEY (id)
);

CREATE TABLE albums (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	release_date date NOT NULL,
	CONSTRAINT albums_pkey PRIMARY KEY (id)
);

CREATE TABLE playlists (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT playlists_pkey PRIMARY KEY (id)
);

CREATE TABLE labels (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT labels_pkey PRIMARY KEY (id)
);
