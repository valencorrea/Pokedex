-- MySQL Script generated by MySQL Workbench
-- Wed Jun  2 12:16:34 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokedex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pokedex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokedex` DEFAULT CHARACTER SET utf8 ;
USE `pokedex` ;

-- -----------------------------------------------------
-- Table `pokedex`.`ENTRENADORES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`ENTRENADORES` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(32) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `pokedex`.`POKEMONES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`POKEMONES` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nivel` INT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `pokedex`.`EVOLUCIONA_A`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`EVOLUCIONA_A` (
  `POKEMON_INICIAL_ID` INT NOT NULL,
  `POKEMON_EVOLUCION_ID` INT NOT NULL,
  INDEX `fk_POKEMONES_has_POKEMONES_POKEMONES2_idx` (`POKEMON_EVOLUCION_ID` ASC) VISIBLE,
  INDEX `fk_POKEMONES_has_POKEMONES_POKEMONES1_idx` (`POKEMON_INICIAL_ID` ASC) VISIBLE,
  CONSTRAINT `fk_POKEMONES_has_POKEMONES_POKEMONES1`
    FOREIGN KEY (`POKEMON_INICIAL_ID`)
    REFERENCES `pokedex`.`POKEMONES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_POKEMONES_has_POKEMONES_POKEMONES2`
    FOREIGN KEY (`POKEMON_EVOLUCION_ID`)
    REFERENCES `pokedex`.`POKEMONES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `pokedex`.`HABILIDADES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`HABILIDADES` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `pokedex`.`POKEMON_EN_ENTRENAMIENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`POKEMON_EN_ENTRENAMIENTO` (
  `POKEMON_ID` INT NOT NULL,
  `ENTRENADOR_ID` INT NOT NULL,
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NIVEL_ACTUAL` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_POKEMONES_has_ENTRENADORES_ENTRENADORES1_idx` (`ENTRENADOR_ID` ASC) VISIBLE,
  INDEX `fk_POKEMONES_has_ENTRENADORES_POKEMONES1_idx` (`POKEMON_ID` ASC) VISIBLE,
  CONSTRAINT `fk_POKEMONES_has_ENTRENADORES_POKEMONES1`
    FOREIGN KEY (`POKEMON_ID`)
    REFERENCES `pokedex`.`POKEMONES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_POKEMONES_has_ENTRENADORES_ENTRENADORES1`
    FOREIGN KEY (`ENTRENADOR_ID`)
    REFERENCES `pokedex`.`ENTRENADORES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `pokedex`.`POKEMON_HABILIDAD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`POKEMON_HABILIDAD` (
  `POKEMON_ID` INT NOT NULL,
  `HABILIDAD_ID` INT NOT NULL,
  INDEX `fk_POKEMONES_has_HABILIDADES_HABILIDADES1_idx` (`HABILIDAD_ID` ASC) VISIBLE,
  INDEX `fk_POKEMONES_has_HABILIDADES_POKEMONES1_idx` (`POKEMON_ID` ASC) VISIBLE,
  CONSTRAINT `fk_POKEMONES_has_HABILIDADES_POKEMONES1`
    FOREIGN KEY (`POKEMON_ID`)
    REFERENCES `pokedex`.`POKEMONES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_POKEMONES_has_HABILIDADES_HABILIDADES1`
    FOREIGN KEY (`HABILIDAD_ID`)
    REFERENCES `pokedex`.`HABILIDADES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `pokedex`.`TIPOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`TIPOS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `pokedex`.`POKEMON_TIPO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokedex`.`POKEMON_TIPO` (
  `POKEMON_ID` INT NOT NULL,
  `TIPO_ID` INT NOT NULL,
  INDEX `fk_POKEMONES_has_TIPOS_TIPOS1_idx` (`TIPO_ID` ASC) VISIBLE,
  INDEX `fk_POKEMONES_has_TIPOS_POKEMONES1_idx` (`POKEMON_ID` ASC) VISIBLE,
  CONSTRAINT `fk_POKEMONES_has_TIPOS_POKEMONES1`
    FOREIGN KEY (`POKEMON_ID`)
    REFERENCES `pokedex`.`POKEMONES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_POKEMONES_has_TIPOS_TIPOS1`
    FOREIGN KEY (`TIPO_ID`)
    REFERENCES `pokedex`.`TIPOS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
