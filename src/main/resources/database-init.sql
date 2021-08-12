CREATE SCHEMA `budgetbox` DEFAULT CHARACTER SET utf8;

CREATE TABLE generic_food (
id INT PRIMARY KEY AUTO_INCREMENT,
food_name VARCHAR(50),
scientific_name VARCHAR(50),
main_group VARCHAR(50),
sub_group VARCHAR(50)
);

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/generic-food.csv'
INTO TABLE generic_food
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(food_name, scientific_name, main_group, sub_group)
SET id = null
;