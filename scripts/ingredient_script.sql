USE dev_cookhome;

drop table if exists ingredient;

create table ingredient(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50),
	type_id INT (6) NOT NULL
);