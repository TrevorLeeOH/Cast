BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, issues, votes, tags, tags_issue;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE issues (
	issue_id SERIAL,
	issue_name varchar(100) NOT NULL UNIQUE,
	user_id integer NOT NULL,
	option_a char(100) NOT NULL,
	option_b char(100) NOT NULL,
	option_c char(100) NOT NULL,
	option_d char(100),
	option_e char(100),
	option_f char(100),
	option_g char(100),
	option_h char(100),
	expiration_date date,
	CONSTRAINT PK_issues PRIMARY KEY (issue_id),
	CONSTRAINT FK_issues_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE votes (
	user_id integer NOT NULL,
	issue_id integer NOT NULL,
	option_a integer NOT NULL,
	option_b integer NOT NULL,
	option_c integer NOT NULL,
	option_d integer,
	option_e integer,
	option_f integer,
	option_g integer,
	option_h integer,
	CONSTRAINT PK_votes PRIMARY KEY (user_id, issue_id),
	CONSTRAINT FK_votes_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_votes_issues FOREIGN KEY (issue_id) REFERENCES issues (issue_id)
	);

CREATE TABLE tags (
	tag_name char(50) NOT NULL,
	tag_id SERIAL,
	CONSTRAINT PK_tags PRIMARY KEY (tag_id)
);

CREATE TABLE tags_issue(
	tag_id integer NOT NULL,
	issue_id integer NOT NULL,
	CONSTRAINT PK_tags_issue PRIMARY KEY (tag_id, issue_id),
	CONSTRAINT FK_tag_id FOREIGN KEY (tag_id) REFERENCES tags (tag_id),
	CONSTRAINT FK_issue_id FOREIGN KEY (issue_id) REFERENCES issues (issue_id)

);
COMMIT TRANSACTION;
