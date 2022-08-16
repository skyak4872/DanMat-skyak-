DROP TABLE User;

CREATE TABLE User(
	userid			VARCHAR(20)			NOT NULL PRIMARY KEY,
	passwd			VARCHAR(16)			NOT NULL,
	email			VARCHAR(20)			NOT NULL UNIQUE KEY
)

SELECT * FROM User;

SELECT passwd FROM User WHERE email = 'donoun6@naver.com' AND userid = 'donoun6';

SELECT * FROM word;

SELECT * FROM word WHERE word LIKE '%수%'