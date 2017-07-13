-- MySQL Workbench Synchronization
-- Generated: 2016-03-14 20:39
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Roland

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tamagu` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `tamagu`.`cliente` (
  `idcliente`       INT(11) NOT NULL AUTO_INCREMENT,
  `nome`            VARCHAR(45) NULL DEFAULT NULL,
  `cpf_cnpj`        VARCHAR(14) NULL DEFAULT NULL,
  `logradouro`      VARCHAR(45) NULL DEFAULT NULL,
  `numero`          VARCHAR(10) NULL DEFAULT NULL,
  `complemento`     VARCHAR(45) NULL DEFAULT NULL,
  `cep`             VARCHAR(10) NULL DEFAULT NULL,
  `bairro`          VARCHAR(30) NULL DEFAULT NULL,
  `cidade`          VARCHAR(45) NULL DEFAULT NULL,
  `estado`          VARCHAR(25) NULL DEFAULT NULL,
  `telefone`        VARCHAR(15) NULL DEFAULT NULL,
  `email`           VARCHAR(45) NULL DEFAULT NULL,
  `contato`         VARCHAR(45) NULL DEFAULT NULL,
  `limiteCredito`   DOUBLE(15,2),
  `senha`           VARCHAR(15) NOT NULL,
  `perfil`          VARCHAR(01) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `tamagu`.`fornecedor` (
  `idfornecedor`    INT(11) NOT NULL AUTO_INCREMENT,
  `nome`            VARCHAR(45) NULL DEFAULT NULL,
  `cpf_cnpj`        VARCHAR(14) NULL DEFAULT NULL,
  `logradouro`      VARCHAR(45) NULL DEFAULT NULL,
  `numero`          VARCHAR(10) NULL DEFAULT NULL,
  `complemento`     VARCHAR(45) NULL DEFAULT NULL,
  `cep`             VARCHAR(10) NULL DEFAULT NULL,
  `bairro`          VARCHAR(30) NULL DEFAULT NULL,
  `cidade`          VARCHAR(45) NULL DEFAULT NULL,
  `estado`          VARCHAR(25) NULL DEFAULT NULL,
  `telefone`        VARCHAR(15) NULL DEFAULT NULL,
  `email`           VARCHAR(45) NULL DEFAULT NULL,
  `contato`         VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idfornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `tamagu`.`produto` (
  `idproduto`       INT(11) NOT NULL AUTO_INCREMENT,
  `descricao`       VARCHAR(45) NULL DEFAULT NULL,
  `marca`           VARCHAR(30) NULL DEFAULT NULL,
  `modelo`          VARCHAR(30) NULL DEFAULT NULL,
  `percentualvenda` DOUBLE(7,4) NULL DEFAULT NULL,  
  `precocompra`     DOUBLE(15,2) NULL DEFAULT NULL,
  `precovenda`      DOUBLE(15,2) NULL DEFAULT NULL,
  `estoque`         DOUBLE(15,2) NULL DEFAULT NULL,
  PRIMARY KEY (`idproduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `tamagu`.`usuario`(
  `idusuario`      VARCHAR(25) NOT NULL,
  `senha`          VARCHAR(15) NOT NULL,
  `perfil`         VARCHAR(01) NOT NULL,
  `idcliente`      INT(11) NOT NULL,
  `status`         VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idusuario`),
  FOREIGN KEY(`idcliente`) REFERENCES cliente (idcliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS tamagu.PCHeader(
  idpedido         INT(11) NOT NULL AUTO_INCREMENT,
  idfornecedor     INT(11) NOT NULL,
  dtLcto           DATE NOT NULL,
  totalPedido      DOUBLE(15,2),
  status           VARCHAR(15),
  PRIMARY KEY (idpedido),
  FOREIGN KEY(idfornecedor) REFERENCES fornecedor (idfornecedor))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS tamagu.PCItem(
    idPedido       INT(11) NOT NULL,
    idProduto      INT(11) NOT NULL,
    quantidade     DOUBLE(15,2),
    vlrUnitario    DOUBLE(15,2),
    vlrTotal       DOUBLE(15,2),
    PRIMARY KEY (idPedido,idProduto),
    FOREIGN KEY (idProduto) REFERENCES produto(idProduto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS tamagu.PVHeader(
  idpedido         INT(11) NOT NULL AUTO_INCREMENT,
  idcliente        INT(11) NOT NULL,
  dtLcto           DATE NOT NULL,
  totalPedido      DOUBLE(15,2),
  status           VARCHAR(15),
  formaPgto        VARCHAR(15),
  PRIMARY KEY (idpedido),
  FOREIGN KEY(idcliente) REFERENCES cliente (idcliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS tamagu.PVItem(
    idPedido       INT(11) NOT NULL,
    idProduto      INT(11) NOT NULL,
    quantidade     DOUBLE(15,2),
    vlrUnitario    DOUBLE(15,2),
    vlrTotal       DOUBLE(15,2),
    PRIMARY KEY (idPedido,idProduto),
    FOREIGN KEY (idProduto) REFERENCES produto(idProduto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `tamagu`.`contato` (
  `idContato`   INT(11) NOT NULL AUTO_INCREMENT,
  `nome`        VARCHAR(30) NULL DEFAULT NULL,
  `email`       VARCHAR(30) NULL DEFAULT NULL,
  `assunto`     VARCHAR(30) NULL DEFAULT NULL,
  `telefone`    VARCHAR(15) NULL DEFAULT NULL,  
  `mensagem`    VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`idContato`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

