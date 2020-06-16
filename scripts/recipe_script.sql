USE dev_cookhome;

DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe(

    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    direction_id VARCHAR(9999) NOT NULL,
    portion_id INT(6),
    ingredient_id INT(6)

);










