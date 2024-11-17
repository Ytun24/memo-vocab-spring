CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_user_id INTEGER,
  last_updated_user_id INTEGER,
  last_updated_at TIMESTAMP
  version INTEGER DEFAULT 1,
  deleted BOOLEAN DEFAULT FALSE
);