DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id BIGINT(36) PRIMARY KEY,
	userEmail VARCHAR(50) NOT NULL,
    userName VARCHAR(50) NOT NULL,
    password VARCHAR(120) NOT NULL,
    birthday DATE,
    role VARCHAR(100)
);
