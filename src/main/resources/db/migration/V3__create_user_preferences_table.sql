CREATE TABLE user_preferences (
  id SERIAL PRIMARY KEY,
  user_id INTEGER,
  email VARCHAR(255),
  phone_number VARCHAR(255),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by VARCHAR(50),
  last_updated_by VARCHAR(50),
  last_updated_at TIMESTAMP,
  version INTEGER DEFAULT 1,
  deleted BOOLEAN DEFAULT FALSE,
  CONSTRAINT fk_user_preferences_user FOREIGN KEY (user_id) REFERENCES users(id)
);