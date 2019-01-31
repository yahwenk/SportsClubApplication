CREATE DATABASE sa46team2;

USE sa46team2;

CREATE TABLE `user` (
  `userID` varchar(10) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `memberID` varchar(10) NOT NULL,
  `status` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`));
  
CREATE TABLE `facility` (
  `facilityID` int(11) NOT NULL AUTO_INCREMENT,
  `facilityName` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`facilityID`));
  


CREATE TABLE `timeslot` (
  `timeSlot` varchar(30) NOT NULL,
  PRIMARY KEY (`timeSlot`));
  
  CREATE TABLE `sa46team2`.`booking` (
  `bookingID` INT NOT NULL AUTO_INCREMENT,
  `userID` VARCHAR(45) NULL,
  `facilityID` INT NULL,
  `bookingDate` DATE NULL,
  `bookingTime` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`bookingID`),
  INDEX `userid_idx` (`userID` ASC) VISIBLE,
  INDEX `facilityid_idx` (`facilityID` ASC) VISIBLE,
  CONSTRAINT `userid`
    FOREIGN KEY (`userID`)
    REFERENCES `sa46team2`.`user` (`userID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `facilityid`
    FOREIGN KEY (`facilityID`)
    REFERENCES `sa46team2`.`facility` (`facilityID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
INSERT INTO `user` VALUES ('1','SongHyo','Lim',25,'Boon Lay',12345678,'Female','password','test@test.com','1','ACTIVE','Admin');
  
INSERT INTO `facility` VALUES ('1','Basketball Court','ACTIVE'),('2','Volleyball Court','ACTIVE');
  



INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('09:00 to 10:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('10:00 to 11:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('11:00 to 12:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('12:00 to 13:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('13:00 to 14:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('14:00 to 15:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('15:00 to 16:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('16:00 to 17:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('17:00 to 18:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('18:00 to 19:00');
INSERT INTO `sa46team2`.`timeslot` (`timeSlot`) VALUES ('19:00 to 20:00');

