
#================================================
## SAPPHIRE DDL SCRIPTS
#================================================

### VENDOR MASTER ###

DROP TABLE IF EXISTS `sapphire`.`vendor`;

CREATE TABLE `sapphire`.`vendor` (
  `VENDOR_ID` INT(5) ZEROFILL NOT NULL AUTO_INCREMENT,
  `VENDOR_NAME` VARCHAR(70) NOT NULL,
  `VENDOR_ADDRESS` VARCHAR(100) NULL,
  `VENDOR_STATE` VARCHAR(2) NULL,
  `VENDOR_CITY` VARCHAR(2) NULL,
  `VENDOR_PIN` VARCHAR(6) NULL,
  `VENDOR_PHONE` VARCHAR(10) NULL,
  `VENDOR_COMMENTS` VARCHAR(200) NULL,
  `CREATED_USER` INT(4) NOT NULL DEFAULT 0,
  `CREATED_TIMESTAMP` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_USER` INT(4) NOT NULL DEFAULT 0,
  `MODIFIED_TIMESTAMP` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETED` VARCHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`VENDOR_ID`)  COMMENT 'Index for searching by Id',
  INDEX `VENDOR_NAME_UNIQUE` (`VENDOR_NAME` ASC)  COMMENT 'Index for searching by vendor name')
ENGINE = InnoDB
AUTO_INCREMENT = 1001
COMMENT = 'VENDOR MASTER TABLE';


### INVENTORY MASTER ###

### STATE MASTER ###

DROP TABLE IF EXISTS `sapphire`.`state`;

CREATE TABLE `sapphire`.`state` (                                                                    
          `StateID` INT(11) NOT NULL AUTO_INCREMENT,                                              
          `CountryID` INT(11) NOT NULL,                                                           
          `StateName` VARCHAR(50) NOT NULL,                                                       
          `Notes` LONGTEXT,                                                                       
          `ChangedBy` VARCHAR(50) DEFAULT NULL,                                                   
          `ChangeDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
          PRIMARY KEY  (`StateID`)                                                                
        ) ENGINE=INNODB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1
        

### CITI MASTER ###

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
DROP TABLE IF EXISTS `sapphire`.`cities`;

CREATE TABLE IF NOT EXISTS `sapphire`.`cities` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `city_state` varchar(100) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1624 ;

