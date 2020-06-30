USE dev_cookhome;

drop table if exists direction;

create table direction(
	
	id INT AUTO_INCREMENT PRIMARY KEY,
	tempo INT(10),
	timeunity VARCHAR(50),
	description VARCHAR(3000),
	recipe_id INT

);