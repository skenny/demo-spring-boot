CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	username TEXT NOT NULL,
	password TEXT NOT NULL,
	enabled BOOLEAN NOT NULL DEFAULT TRUE,
	roles TEXT
);

INSERT INTO users(first_name, last_name, username, password, enabled, roles) VALUES (
	'Admin',
	'User',
	'admin',
	'$2a$04$1jml7iY4P7APEUCQG7cD9ep65i.2tkKAnkciNLFtPMrE8VObC4XoG',	-- 'password'
	true,
	'["ADMIN"]'
);
