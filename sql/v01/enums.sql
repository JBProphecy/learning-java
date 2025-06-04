CREATE TYPE collection AS ENUM ('single', 'album', 'playlist', 'label');
CREATE TYPE releasable_collection AS ENUM ('single', 'album');
CREATE TYPE customizable_collection AS ENUM ('playlist', 'label');