USE dev_cookhome;

drop table if exists relacionamento_geral;

create table relacionamento_geral(
	ingredient_id INT(6) NOT NULL,
	type_id INT(6) NOT NULL,
	recipe_id INT(6) NOT NULL
	group1_id INT(6) NOT NULL
)
