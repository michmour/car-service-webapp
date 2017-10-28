CREATE DATABASE  IF NOT EXISTS `carserviceproject` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `carserviceproject`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: carserviceproject
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `repair`
--

DROP TABLE IF EXISTS `repair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repair` (
  `serviceid` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `servicecost` int(11) DEFAULT NULL,
  `servicedate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `userelid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`serviceid`),
  KEY `FKo35x6596aybv8tpajl4l28vil` (`userelid`),
  CONSTRAINT `FKo35x6596aybv8tpajl4l28vil` FOREIGN KEY (`userelid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair`
--

LOCK TABLES `repair` WRITE;
/*!40000 ALTER TABLE `repair` DISABLE KEYS */;
INSERT INTO `repair` VALUES (14,'2017-10-26 15:26:16','some details',123,'2017-10-31 02:32:00','COMPLETED','BIG','2017-10-26 15:26:16',3),(15,'2017-10-26 16:25:43','some details',123,'2017-10-31 00:12:00','PENDING','SMALL','2017-10-26 16:25:43',3),(16,'2017-10-29 00:35:44','some details',123,'2017-10-31 21:34:00','PENDING','SMALL','2017-10-29 00:35:44',1),(17,'2017-10-29 00:40:41','some details',90,'2018-04-29 18:06:00','PENDING','SMALL','2017-10-29 00:40:41',5),(18,'2017-10-29 00:44:23','some details',250,'2017-04-04 13:06:00','COMPLETED','BIG','2017-10-29 00:44:23',4);
/*!40000 ALTER TABLE `repair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_o14ahnprxuevixmhn8cg59s4d` (`ssn`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Athanasiou Diakou 55C','2017-10-23 06:19:52','riblee@gmail.com','George','12345678','566566666','Koukoulakis','2017-10-29 00:37:52','ADMIN'),(3,'Athanasiou Diakou 55C','2017-10-23 18:52:37','hello@gmail.com','ownegr','12345678','566556666','Koukoulakis','2017-10-29 00:36:31','OWNER'),(4,'Athanasiou Diakou 55C','2017-10-29 00:36:25','rikjblele@gmail.com','George','12345678','767676887','Datsik','2017-10-29 00:36:25','OWNER'),(5,'TEMPON 9, GLYFADA','2017-10-29 00:37:39','michmour@gmail.com','Mich','12345678','787878789','Moor','2017-10-29 00:37:39','OWNER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `vehicleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `colour` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `platenumber` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `vehiclemodel` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `userelid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`vehicleid`),
  UNIQUE KEY `UK_66q9kq26lb4acse8fl1ji3kvk` (`platenumber`),
  KEY `FKrib23m333w81exsve7co1pwer` (`userelid`),
  CONSTRAINT `FKrib23m333w81exsve7co1pwer` FOREIGN KEY (`userelid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'asas','2017-10-26 00:28:13','ABC-1234','2017-10-26 00:28:13','NISSAN','2013',1),(3,'asas','2017-10-26 00:41:36','ABC-1237','2017-10-26 00:41:36','NISSAN','2013',3),(4,'black','2017-10-29 00:48:13','ITA-4312','2017-10-29 00:48:13','TOYOTA','2013',1),(5,'white','2017-10-29 00:48:42','ITB-3231','2017-10-29 00:48:42','MAZDA','2002',1),(6,'red','2017-10-29 00:49:15','IIT-0489','2017-10-29 00:49:15','OPEL','2002',5);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'carserviceproject'
--

--
-- Dumping routines for database 'carserviceproject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-29  0:53:38
