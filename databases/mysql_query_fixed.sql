-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shopping-cart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shopping-cart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopping-cart` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopping-cart` ;

-- -----------------------------------------------------
-- Table `shopping-cart`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`product` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`product` (
  `pid` VARCHAR(45) NOT NULL,
  `pname` VARCHAR(100) NULL DEFAULT NULL,
  `ptype` VARCHAR(20) NULL DEFAULT NULL,
  `pinfo` VARCHAR(350) NULL DEFAULT NULL,
  `pprice` DECIMAL(12,2) NULL DEFAULT NULL,
  `pquantity` INT NULL DEFAULT NULL,
  `image` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`pid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `shopping-cart`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`user` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`user` (
  `email` VARCHAR(60) NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `mobile` BIGINT NULL DEFAULT NULL,
  `address` VARCHAR(250) NULL DEFAULT NULL,
  `pincode` INT NULL DEFAULT NULL,
  `password` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `shopping-cart`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`orders` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`orders` (
  `orderid` VARCHAR(45) NOT NULL,
  `prodid` VARCHAR(45) NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `amount` DECIMAL(10,2) NULL DEFAULT NULL,
  `shipped` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`orderid`, `prodid`),
  INDEX `productid_idx` (`prodid` ASC) VISIBLE,
  CONSTRAINT `productid`
    FOREIGN KEY (`prodid`)
    REFERENCES `shopping-cart`.`product` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `shopping-cart`.`transactions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`transactions` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`transactions` (
  `transid` VARCHAR(45) NOT NULL,
  `username` VARCHAR(60) NULL DEFAULT NULL,
  `time` DATETIME NULL DEFAULT NULL,
  `amount` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`transid`),
  INDEX `truserid_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `truserid`
    FOREIGN KEY (`username`)
    REFERENCES `shopping-cart`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `shopping-cart`.`user_demand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`user_demand` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`user_demand` (
  `username` VARCHAR(60) NOT NULL,
  `prodid` VARCHAR(45) NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`username`, `prodid`),
  INDEX `prodid_idx` (`prodid` ASC) VISIBLE,
  CONSTRAINT `userdemailemail`
    FOREIGN KEY (`username`)
    REFERENCES `shopping-cart`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prodid`
    FOREIGN KEY (`prodid`)
    REFERENCES `shopping-cart`.`product` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `shopping-cart`.`usercart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping-cart`.`usercart` ;

CREATE TABLE IF NOT EXISTS `shopping-cart`.`usercart` (
  `username` VARCHAR(60) NOT NULL,
  `prodid` VARCHAR(45) NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`username`, `prodid`),
  INDEX `cprodid_idx` (`prodid` ASC) VISIBLE,
  CONSTRAINT `cartusername`
    FOREIGN KEY (`username`)
    REFERENCES `shopping-cart`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cprodid`
    FOREIGN KEY (`prodid`)
    REFERENCES `shopping-cart`.`product` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Insert sample data
INSERT INTO `shopping-cart`.`user` (`email`, `name`, `mobile`, `address`, `pincode`, `password`) VALUES
('admin@admin.com', 'Admin', 1234567890, 'Admin Address', 123456, 'admin'),
('user@user.com', 'User', 9876543210, 'User Address', 654321, 'user');

INSERT INTO `shopping-cart`.`product` (`pid`, `pname`, `ptype`, `pinfo`, `pprice`, `pquantity`) VALUES
('P001', 'Samsung Galaxy S21', 'mobile', 'Latest Samsung smartphone with amazing features', 799.99, 50),
('P002', 'iPhone 13', 'mobile', 'Apple iPhone with A15 Bionic chip', 999.99, 30),
('P003', 'MacBook Pro', 'laptop', 'Professional laptop for developers', 1999.99, 10),
('P004', 'Dell XPS 13', 'laptop', 'Ultrabook with Intel i7 processor', 1299.99, 15),
('P005', 'Sony WH-1000XM4', 'electronics', 'Noise cancelling wireless headphones', 349.99, 25);
