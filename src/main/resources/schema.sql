DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id         INTEGER IDENTITY PRIMARY KEY,
  user_name VARCHAR(50),
  email_address    VARCHAR(255),
  registered_date Date
);

INSERT INTO users VALUES (1, 'Anusha', 'anusha.t2601@gmail.com', sysdate);
INSERT INTO users VALUES (2, 'Ramesh', 'ramesh.t@gmail.com', sysdate);
INSERT INTO users VALUES (3, 'Malathi', 'malathi.t@gmail.com', sysdate);
INSERT INTO users VALUES (4, 'Aakash', 'aakash.t@gmail.com', sysdate);



