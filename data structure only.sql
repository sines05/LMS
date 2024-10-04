/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.34-log : Database - lms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lms`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(60) DEFAULT NULL,
  `middlename` varchar(60) DEFAULT NULL,
  `lastname` varchar(60) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `notes` varchar(250) DEFAULT NULL,
  `subjects` varchar(250) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `quantity` int(1) DEFAULT '0',
  `price` float DEFAULT '0',
  `callNoL1` int(11) DEFAULT NULL,
  `callNoL2` varchar(30) DEFAULT NULL,
  `callNoL3` varchar(30) DEFAULT NULL,
  `callNoL4` int(4) DEFAULT '1950',
  `genre_id` int(11) DEFAULT NULL,
  `book_recieve_id` int(11) DEFAULT NULL,
  `damage` tinyint(4) DEFAULT '0',
  `lost` tinyint(4) DEFAULT '0',
  `borrowed` tinyint(4) DEFAULT '0',
  `photo` mediumblob,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `publisher_id` (`publisher_id`),
  KEY `callNoL1` (`callNoL1`),
  KEY `genre_id` (`genre_id`),
  KEY `book_recieve_id` (`book_recieve_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`callNoL1`) REFERENCES `call_number_line1` (`id`),
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `book_ibfk_4` FOREIGN KEY (`book_recieve_id`) REFERENCES `book_receive` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=533 DEFAULT CHARSET=latin1;

/*Table structure for table `book_author` */

DROP TABLE IF EXISTS `book_author`;

CREATE TABLE `book_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `book_author_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `book_author_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

/*Table structure for table `book_borrowed` */

DROP TABLE IF EXISTS `book_borrowed`;

CREATE TABLE `book_borrowed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `borrowed_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `return_date_time` datetime DEFAULT NULL,
  `penalty_id` int(11) DEFAULT NULL,
  `book_return` tinyint(4) DEFAULT '0',
  `user_receive_penalty` int(11) DEFAULT '0',
  `penalty_paid` tinyint(4) DEFAULT '0',
  `date_penalty_paid` timestamp NULL DEFAULT NULL,
  `missing` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `student_id` (`student_id`),
  KEY `user_id` (`user_id`),
  KEY `penalty_id` (`penalty_id`),
  CONSTRAINT `book_borrowed_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `book_borrowed_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `book_borrowed_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `book_borrowed_ibfk_4` FOREIGN KEY (`penalty_id`) REFERENCES `penalty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

/*Table structure for table `book_receive` */

DROP TABLE IF EXISTS `book_receive`;

CREATE TABLE `book_receive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `purchaser_id` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `purchaser_id` (`purchaser_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `book_receive_ibfk_1` FOREIGN KEY (`purchaser_id`) REFERENCES `purchaser` (`id`),
  CONSTRAINT `book_receive_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Table structure for table `call_number_line1` */

DROP TABLE IF EXISTS `call_number_line1`;

CREATE TABLE `call_number_line1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `letter` varchar(5) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course` varchar(60) DEFAULT NULL,
  `acronym` varchar(10) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `genre` */

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) DEFAULT NULL,
  `genre` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `genre_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rate` float DEFAULT '0',
  `active` tinyint(4) DEFAULT '0',
  `date_start` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  `days` int(11) DEFAULT '3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher` varchar(120) DEFAULT NULL,
  `address` varchar(550) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `purchaser` */

DROP TABLE IF EXISTS `purchaser`;

CREATE TABLE `purchaser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `middlename` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `mobile_no` varchar(12) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` bigint(20) DEFAULT '1',
  `firstname` varchar(80) DEFAULT NULL,
  `middlename` varchar(80) DEFAULT NULL,
  `lastname` varchar(80) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `mobile_no` varchar(16) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `guardian` varchar(200) DEFAULT NULL,
  `photo` mediumblob,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(80) DEFAULT NULL,
  `middlename` varchar(80) DEFAULT NULL,
  `lastname` varchar(80) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `mobile_no` varchar(120) DEFAULT NULL,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `photo` mediumblob,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
