USE dev_cookhome;

DROP TABLE IF EXISTS recipe_ingredient;

CREATE TABLE recipe_ingredient(
	
	recipe_id INT(6) NOT NULL,
	ingredient_id INT(6) NOT NULL
		
);
