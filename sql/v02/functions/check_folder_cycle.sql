CREATE FUNCTION check_general_folder_general_folders_cycle()
RETURNS TRIGGER AS $$
BEGIN
  IF NEW.parent_id = NEW.child_id THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  WITH RECURSIVE ancestors (id) AS (
    SELECT parent_id FROM general_folder_general_folders
    WHERE child_id = NEW.parent_id
    UNION
    SELECT general_folder_general_folders.parent_id
    FROM general_folder_general_folders JOIN ancestors
    ON general_folder_general_folders.child_id = ancestors.id
  );

  PERFORM 1 FROM ancestors
  WHERE id = NEW.child_id
  LIMIT 1;

  IF FOUND THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION check_single_folder_single_folders_cycle()
RETURNS TRIGGER AS $$
BEGIN
  IF NEW.parent_id = NEW.child_id THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  WITH RECURSIVE ancestors (id) AS (
    SELECT parent_id FROM single_folder_single_folders
    WHERE child_id = NEW.parent_id
    UNION
    SELECT single_folder_single_folders.parent_id
    FROM single_folder_single_folders JOIN ancestors
    ON single_folder_single_folders.child_id = ancestors.id
  );

  PERFORM 1 FROM ancestors
  WHERE id = NEW.child_id
  LIMIT 1;

  IF FOUND THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION check_album_folder_album_folders_cycle()
RETURNS TRIGGER AS $$
BEGIN
  IF NEW.parent_id = NEW.child_id THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  WITH RECURSIVE ancestors (id) AS (
    SELECT parent_id FROM album_folder_album_folders
    WHERE child_id = NEW.parent_id
    UNION
    SELECT album_folder_album_folders.parent_id
    FROM album_folder_album_folders JOIN ancestors
    ON album_folder_album_folders.child_id = ancestors.id
  );

  PERFORM 1 FROM ancestors
  WHERE id = NEW.child_id
  LIMIT 1;

  IF FOUND THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION check_playlist_folder_playlist_folders_cycle()
RETURNS TRIGGER AS $$
BEGIN
  IF NEW.parent_id = NEW.child_id THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  WITH RECURSIVE ancestors (id) AS (
    SELECT parent_id FROM playlist_folder_playlist_folders
    WHERE child_id = NEW.parent_id
    UNION
    SELECT playlist_folder_playlist_folders.parent_id
    FROM playlist_folder_playlist_folders JOIN ancestors
    ON playlist_folder_playlist_folders.child_id = ancestors.id
  );

  PERFORM 1 FROM ancestors
  WHERE id = NEW.child_id
  LIMIT 1;

  IF FOUND THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION check_label_folder_label_folders_cycle()
RETURNS TRIGGER AS $$
BEGIN
  IF NEW.parent_id = NEW.child_id THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  WITH RECURSIVE ancestors (id) AS (
    SELECT parent_id FROM label_folder_label_folders
    WHERE child_id = NEW.parent_id
    UNION
    SELECT label_folder_label_folders.parent_id
    FROM label_folder_label_folders JOIN ancestors
    ON label_folder_label_folders.child_id = ancestors.id
  );

  PERFORM 1 FROM ancestors
  WHERE id = NEW.child_id
  LIMIT 1;

  IF FOUND THEN
    RAISE EXCEPTION 'Circular Reference Detected';
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;