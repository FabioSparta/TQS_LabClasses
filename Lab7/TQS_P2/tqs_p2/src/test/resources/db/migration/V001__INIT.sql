CREATE TABLE books (
  id BIGSERIAL PRIMARY KEY,
  name varchar(255) not null
);

INSERT INTO books(name) VALUES ('A book sample');