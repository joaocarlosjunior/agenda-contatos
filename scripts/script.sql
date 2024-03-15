CREATE TABLE contato(
id int(4) AUTO_INCREMENT,
nome varchar(30) NOT NULL,
fone varchar(15) NOT NULL,
email varchar(60),
PRIMARY KEY (id),
CONSTRAINT fone_unique UNIQUE (fone),
CONSTRAINT email_unique UNIQUE (email)
);