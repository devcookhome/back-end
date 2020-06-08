USE dev_cookhome;

drop table if exists direction;

create table direction(
	id INT AUTO_INCREMENT;
	tempo INT(10),
	timeunity VARCHAR(50),
	description VARCHAR(50)
)