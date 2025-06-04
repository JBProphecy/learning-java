CREATE FUNCTION transfer_profile(
  p_profile_id text,
  p_old_account_id text,
  p_new_account_id text
)
RETURNS VOID AS $$
BEGIN
  UPDATE profiles
  SET account_id = p_new_account_id
  WHERE id = p_profile_id AND account_id = p_old_account_id;

  DELETE FROM transfer_profile_requests
  WHERE profile_id = p_profile_id
    AND from_account_id = p_old_account_id
    AND to_account_id = p_new_account_id;
  RETURN;
END;
$$ LANGUAGE plpgsql;