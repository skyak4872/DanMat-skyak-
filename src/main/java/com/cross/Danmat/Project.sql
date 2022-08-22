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

CREATE TABLE Manager(
mgid		VARCHAR(20)		NOT NULL UNIQUE KEY,
mgpasswd	VARCHAR(16)		NOT NULL
)

SELECT * FROM Manager;

INSERT INTO Manager(mgid, mgpasswd) VALUES ('admin', '12345678');

UPDATE Manager SET mgpasswd = '12345678' WHERE mgid = 'admin'

CREATE TABLE Word (
wid			INT				PRIMARY KEY AUTO_INCREMENT,
word		VARCHA 	R(100)	NOT NULL,
len			INT				NOT NULL,
grade		VARCHAR(100)	NOT NULL,
category	VARCHAR(500)	DEFAULT NULL,
category2	VARCHAR(200)	DEFAULT NULL,
def			VARCHAR(2000)	NOT NULL,
ex			VARCHAR(2000)	NOT NULL
)

SELECT * FROM Word;

DROP TABLE word