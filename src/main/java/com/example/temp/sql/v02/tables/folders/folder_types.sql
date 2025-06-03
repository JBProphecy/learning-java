CREATE TABLE general_folders (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT general_folders_pkey PRIMARY KEY (id)
);

CREATE TABLE single_folders (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT single_folders_pkey PRIMARY KEY (id)
);

CREATE TABLE album_folders (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT album_folders_pkey PRIMARY KEY (id)
);

CREATE TABLE playlist_folders (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT playlist_folders_pkey PRIMARY KEY (id)
);

CREATE TABLE label_folders (
	id text NOT NULL,
	name text NOT NULL,
  front_cover_url,
  back_cover_url,
	description text,
	CONSTRAINT label_folders_pkey PRIMARY KEY (id)
);