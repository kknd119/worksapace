CREATE TABLE `tb_slae` (
	`pdno` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`kind` VARCHAR(50) NOT NULL,
	`manufacturer` VARCHAR(30) NOT NULL,
	`price` INT(11) NOT NULL,
	`quantity` INT(11) NOT NULL,
	PRIMARY KEY (`pdno`)
)