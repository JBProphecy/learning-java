CREATE TABLE accounts (
	id text NOT NULL, -- custom ID for pretty links (may switch back to UUID)
	name text NOT NULL,
	email text NOT NULL,
	password text NOT NULL,

	CONSTRAINT accounts_pkey PRIMARY KEY (id),
	CONSTRAINT accounts_email_key UNIQUE (email)
);

CREATE TABLE profiles (
	id text NOT NULL, -- custom ID for pretty links (may switch back to UUID)
	name text NOT NULL,
	username text NOT NULL,
	password text NOT NULL,
	account_id text NOT NULL,
	profile_picture_url text,

	CONSTRAINT profiles_pkey PRIMARY KEY (id),
	CONSTRAINT profiles_username_key UNIQUE (username),

	CONSTRAINT profiles_account_id_fkey
    FOREIGN KEY (account_id)
		REFERENCES accounts (id)
			ON UPDATE NO ACTION -- accounts.id is a primary key and primary keys should never change
			ON DELETE CASCADE -- if an account is deleted, all of its profiles will be deleted as well
);

CREATE TABLE profile_transfer_requests (
  profile_id text NOT NULL,
  from_account_id text NOT NULL,
  to_account_id text NOT NULL,
  requested_at timestamptz NOT NULL DEFAULT now(),

  CONSTRAINT profile_transfer_requests_pkey PRIMARY KEY (profile_id), -- only one record can exist at a time for each profile
  CONSTRAINT are_accounts_different CHECK (from_account_id <> to_account_id) -- the two accounts in each record must be different

  CONSTRAINT profile_transfer_requests_profile_id_fkey
    FOREIGN KEY (profile_id)
    REFERENCES profiles (id)
      ON UPDATE NO ACTION -- profiles.id is a primary key and primary keys should never change
      ON DELETE CASCADE, -- if a profile is deleted and a profile transfer request exists for that profile, it will be deleted as well
  
  CONSTRAINT profile_transfer_requests_from_account_id_fkey
    FOREIGN KEY (from_account_id)
    REFERENCES accounts (id)
      ON UPDATE NO ACTION -- accounts.id is a primary key and primary keys should never change
      ON DELETE CASCADE, -- if an account is deleted, any profile transfer requests from that account will be deleted as well
  
  CONSTRAINT profile_transfer_requests_to_account_id_fkey
    FOREIGN KEY (to_account_id)
    REFERENCES accounts (id)
      ON UPDATE NO ACTION -- accounts.id is a primary key and primary keys should never change
      ON DELETE CASCADE, -- if an account is deleted, any profile transfer requests to that account will be deleted as well
);