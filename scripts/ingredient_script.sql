USE dev_cookhome;

drop table if exists ingredient;

create table ingredient(
	id INT AUTO_INCREMENT,   
	name VARCHAR(50),
	type VARCHAR(50)
)