CREATE TABLE track_audio_files (
	id text NOT NULL,
	track_id text NOT NULL,
	file_url text NOT NULL,
	file_type varchar(10) NOT NULL, -- audio format
	file_size bigint NOT NULL,
	bitrate integer NOT NULL, -- audio specific
	duration bigint NOT NULL,
	CONSTRAINT track_audio_files_pkey PRIMARY KEY (id),
	CONSTRAINT track_audio_files_track_id_key UNIQUE (track_id)
);
