CREATE TABLE user_preferences (
  id SERIAL PRIMARY KEY,
  user_id INTEGER,
  email VARCHAR(255),
  phone_number VARCHAR(255),
  CONSTRAINT fk_user_preferences_user FOREIGN KEY (user_id) REFERENCES users(id)
);