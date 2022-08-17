BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('issuer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ISSUER');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, expiration_date)
VALUES ('Why You Vote', 'Rank these issues on their importance in determining your vote in the upcoming election', 1, 'Environment', 'Health Care', 'Economy', 'Foreign Relations', '08-01-2022');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e, option_f, option_g, option_h)
VALUES ('Political Labels', 'Rank these labels from most positive association to least', 1, 'Moderate', 'Liberal', 'Conservative', 'Centrist', 'Progressive', 'Republican', 'Democrat', 'Independent');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e)
VALUES ('Democratic Primary Candidates', 'If Joe Biden decided not to run for reelection and the Democratic primary were held today, rank these choices from most likely to least likely to have your support:', 1, 'Kamala Harris', 'Bernie Sanders', 'Corey Booker', 'Amy Klobuchar', 'Pete Buttigieg');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e)
VALUES ('Republican Primary Candidates', 'If the Republican presidential primary were held today, rank these choices from most likely to least likely to have your support:', 1, 'Donald Trump', 'Mike Pence', 'Ted Cruz', 'Nikki Haley', 'Ron DeSantis');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e)
VALUES ('Third Parties', 'Rank these third parties based on how much you know about them from most to least:', 1, 'Libertarian Party', 'Green Party', 'Constitutional Party', 'Rent Is Too Damn High Party', 'Socialist Party USA');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e)
VALUES ('Gun Violence Policy Solutions', 'Rank from most preferred to least preferred these policy solutions to gun violence:', 1, 'Do Nothing', 'Incentivize Increased Gun Ownership for Self Protection', 'Minimal Increases in Firearm Regulations i.e Background Checks', 'Assault Weapons Ban', 'Full Firearm Ban');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d)
VALUES ('Health Care Systems', 'Rank from most preferred to least preferred these forms of health care systems', 1, 'Universal Government Funded Health Care', 'Fully Privatized Health Insurance', 'Government Assistance only for Those Who Meet Strict Requirements', 'Employer Provided Health Insurance');

INSERT INTO issues (issue_name, description, user_id, option_a, option_b, option_c, option_d, option_e)
VALUES ('Environmental Impacts', 'Rank these issues by how much they impact your community from most impactful to least impactful', 1, 'Water Contamination', 'Air Quality', 'Climate Change', 'Sustainable Energy', 'Waste Disposal');

INSERT INTO tags (tag_name)  --1
VALUES ('environment');

INSERT INTO tags (tag_name)  --2
VALUES ('social');

INSERT INTO tags (tag_name)  --3
VALUES ('electoral');

INSERT INTO tags (tag_name)  --4
VALUES ('policy');

INSERT INTO tags (tag_name)  --5
VALUES ('Dem');

INSERT INTO tags (tag_name)  --6
VALUES ('Repub');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('1', '2');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('1', '3');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('1', '5');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('1', '6');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('2', '4');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('2', '3');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('2', '5');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('2', '6');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('3', '1');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('3', '2');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('3', '3');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('3', '4');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('3', '5');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('4', '1');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('4', '6');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('4', '7');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('4', '8');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('5', '2');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('5', '3');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('5', '5');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('6', '2');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('6', '4');

INSERT INTO tags_issue (tag_id, issue_id)
VALUES ('6', '5');


COMMIT TRANSACTION;
