CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));

INSERT INTO users (username, encoded_password) VALUES('user1','1461c68bf56007488b0bfa3c77b800f53fcb474bacf0be5488cbe00808e1128af03a174524e023b5');

ALTER TABLE customers ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';
ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;