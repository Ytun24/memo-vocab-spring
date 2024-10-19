CREATE TABLE favorites (
  id SERIAL PRIMARY KEY,
  vocab_id INTEGER,
  user_id INTEGER,
  CONSTRAINT fk_favorites_user FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_favorites_vocab FOREIGN KEY (vocab_id) REFERENCES vocabulary(id)
);