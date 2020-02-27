/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.28-log : Database - evoucher
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`evoucher` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `evoucher`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `custid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`custid`),
  UNIQUE KEY `UNIQUE` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `customer` */

insert  into `customer`(`custid`,`mobile`) values (3,'777745673'),(5,'8793659608'),(1,'8856000732'),(4,'887634565'),(2,'989000732');

/*Table structure for table `custvouchers` */

DROP TABLE IF EXISTS `custvouchers`;

CREATE TABLE `custvouchers` (
  `custid` bigint(20) unsigned NOT NULL,
  `vid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`custid`,`vid`),
  KEY `FK VOUCHER` (`vid`),
  CONSTRAINT `FK CUST` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK VOUCHER` FOREIGN KEY (`vid`) REFERENCES `vouchers` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `custvouchers` */

insert  into `custvouchers`(`custid`,`vid`) values (2,3);

/*Table structure for table `redimvoucher` */

DROP TABLE IF EXISTS `redimvoucher`;

CREATE TABLE `redimvoucher` (
  `vid` bigint(20) NOT NULL,
  `uid` bigint(20) NOT NULL,
  PRIMARY KEY (`vid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `redimvoucher` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usrname` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwd` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `utype` tinyint(4) DEFAULT NULL COMMENT '0->admin,1->merchant',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UNIQUE` (`usrname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`uid`,`fname`,`lname`,`usrname`,`passwd`,`utype`) values (1,'Shubham','Pahurkar','shubhampahurkar@gmail.com','ptspl$123',0);

/*Table structure for table `vouchers` */

DROP TABLE IF EXISTS `vouchers`;

CREATE TABLE `vouchers` (
  `vid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `amt` decimal(6,2) NOT NULL,
  `startdate` date NOT NULL,
  `expdate` date NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `vouchers` */

insert  into `vouchers`(`vid`,`amt`,`startdate`,`expdate`) values (1,2000.00,'2020-02-26','2020-03-02'),(2,3000.00,'2020-02-26','2020-03-02'),(3,4000.00,'2020-02-26','2020-02-02'),(4,5000.00,'2020-02-26','2020-03-02'),(5,6000.00,'2020-02-26','2020-03-02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
