USE dev_cookhome;

drop table if exists type;

create table type(
	id INT AUTO_INCREMENT PRIMARY KEY,
	type VARCHAR (50)
)