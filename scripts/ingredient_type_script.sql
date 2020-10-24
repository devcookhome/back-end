USE dev_cookhome;

DROP TABLE IF EXISTS ingredient_type;

CREATE TABLE ingredient_type(
	
	type_id INT(6) NOT NULL,
	ingredient_id INT(6) NOT NULL,
	qtd VARCHAR(50)

		
);
