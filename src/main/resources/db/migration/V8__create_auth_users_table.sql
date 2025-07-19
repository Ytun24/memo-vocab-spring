CREATE TABLE auth_users (
  id SERIAL PRIMARY KEY,
  username varchar(45) NOT NULL,
  password varchar(100) NOT NULL,
  role varchar(45) NOT NULL
);