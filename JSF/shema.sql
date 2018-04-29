
CREATE TABLE user_table (
		id SERIAL,
		username VARCHAR(255),
		password VARCHAR(255),
		gender VARCHAR(255),
		image BYTEA,
		firstname VARCHAR(255),
		lastname VARCHAR(255),
		email VARCHAR(255),
		phone VARCHAR(255)
	);

CREATE TABLE user_role_sw (
		user_id INT4,
		role_id INT4
	);

CREATE TABLE role_table (
		id SERIAL,
		name VARCHAR(255)
	);


ALTER TABLE user_table ADD CONSTRAINT user_pkey PRIMARY KEY (id);

ALTER TABLE role_table ADD CONSTRAINT role_pkey PRIMARY KEY (id);

ALTER TABLE user_role_sw ADD CONSTRAINT role_id FOREIGN KEY (role_id)
	REFERENCES role_table (id);

ALTER TABLE user_role_sw ADD CONSTRAINT user_id FOREIGN KEY (user_id)
	REFERENCES user_table (id);

	
INSERT INTO "role_table" ("id", "name") VALUES ('1', 'user');
INSERT INTO "role_table" ("id", "name") VALUES ('2', 'manager');
INSERT INTO "role_table" ("id", "name") VALUES ('3', 'admin');

