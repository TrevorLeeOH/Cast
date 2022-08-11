BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c)
VALUES ('Murder', 'What are your thoughts on Murder?', 1, 'Love it', 'Hate it', 'Indifferent');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d)
VALUES ('Why You Vote', 'Rank these issues on their importance in determining your vote in the upcoming election', 1, 'Environment', 'Health Care', 'Economy', 'Foreign Relations');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e, option_f, option_g, option_h)
VALUES ('Political Labels', 'Rank these labels from most positive association to least', 1, 'Moderate', 'Liberal', 'Conservative', 'Centrist', 'Progressive', 'Republican', 'Democrat', 'Independent');

COMMIT TRANSACTION;
