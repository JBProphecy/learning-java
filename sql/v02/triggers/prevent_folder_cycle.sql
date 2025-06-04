CREATE TRIGGER prevent_general_folder_cycle
BEFORE INSERT OR UPDATE ON general_folder_general_folders
FOR EACH ROW
EXECUTE FUNCTION check_folder_cycle();

CREATE TRIGGER prevent_single_folder_cycle
BEFORE INSERT OR UPDATE ON single_folder_single_folders
FOR EACH ROW
EXECUTE FUNCTION check_folder_cycle();

CREATE TRIGGER prevent_album_folder_cycle
BEFORE INSERT OR UPDATE ON album_folder_album_folders
FOR EACH ROW
EXECUTE FUNCTION check_folder_cycle();

CREATE TRIGGER prevent_playlist_folder_cycle
BEFORE INSERT OR UPDATE ON playlist_folder_playlist_folders
FOR EACH ROW
EXECUTE FUNCTION check_folder_cycle();

CREATE TRIGGER prevent_label_folder_cycle
BEFORE INSERT OR UPDATE ON label_folder_label_folders
FOR EACH ROW
EXECUTE FUNCTION check_folder_cycle();