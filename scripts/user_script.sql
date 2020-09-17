USE dev_cookhome;

drop table if exists user;

create table user(
	
	id INT AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(50) NOT NULL UNIQUE,
	username VARCHAR(20) NOT NULL UNIQUE,
	name VARCHAR(50) NOT NULL,
	user_password VARCHAR (100) NOT NULL

);