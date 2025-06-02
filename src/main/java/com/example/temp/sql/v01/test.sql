INSERT INTO albums (id, name, release_date)
VALUES
  ('5053', 'My First Album', '2025-06-02'), -- two songs
  ('8436', 'My Second Album', '2025-07-04') -- no songs
;

INSERT INTO singles (id, name, release_date)
VALUES
  ('6844', 'My First Single', '2025-12-25'), -- one song
  ('5521', 'My Second Single', '2025-04-20') -- one song
;

INSERT INTO tracks (id, name, collection_id, collection_type)
VALUES
  ('3227', 'My First Track', '5053', 'album'),
  ('1469', 'My Second Track', '5053', 'album'),
  ('4893', 'My Third Track', '6844', 'single'),
  ('0354', 'My Fourth Track', '5521', 'single')
;

INSERT INTO album_tracks (album_id, track_id, track_number)
VALUES
  ('5053', '3227', 1),
  ('5053', '1469', 2)
;

INSERT INTO single_tracks (single_id, track_id, track_number)
VALUES
  ('6844', '4893', 1),
  ('5521', '0354', 1)
;

INSERT INTO track_audio_files (id, track_id, file_url, file_type, file_size, bitrate, duration)
VALUES
  ('9959', '3227', 'https://track-one-link-one', 'mp3', 3325459, 192, 157465),
  ('2328', '3227', 'https://track-one-link-two', 'wav', 6684349, 320, 157465),
  ('7345', '1469', 'https://track-two-link-one', 'mp3', 2987560, 192, 202340),
  ('2995', '4893', 'https://track-three-link-one', 'mp3', 2945503, 192, 134544),
  ('1003', '0354', 'https://track-four-link-one', 'mp3', 3489211, 192, 148799),
;