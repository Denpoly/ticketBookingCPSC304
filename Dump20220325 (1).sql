-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketbooking
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comedyevent`
--

DROP TABLE IF EXISTS `comedyevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comedyevent` (
  `eid` varchar(45) NOT NULL,
  `age_limit` int NOT NULL,
  `standUp` tinyint NOT NULL,
  PRIMARY KEY (`eid`),
  CONSTRAINT `eid-comedy` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comedyevent`
--

LOCK TABLES `comedyevent` WRITE;
/*!40000 ALTER TABLE `comedyevent` DISABLE KEYS */;
INSERT INTO `comedyevent` VALUES ('1',16,1),('10',16,1),('5',21,0),('7',8,1),('9',21,1);
/*!40000 ALTER TABLE `comedyevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `points` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_number_UNIQUE` (`mobile_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (12345,'adamdi134@hotmail.com','1938237742','adamD102','V6T 1z3','password!','Adam','Dixon', 22),(124,'denpollly@yahoo.com','1237228304','denpoly','80465','pass123','Dennis','Polyakov', 22),(12308,'mattmemme@live.com','1230948392','mattmemme','V6T 1z3','123pass','Matthew','Memme', 26),(123984,'testUser1@hotmail.com','1938462883','testUser1','V5N 1W1','passlel12','John','Smith', 18),(0,'testUser2@hotmail.com','1299334833','testUser2','94704','newPassword','Jacob','Tan', 29),(241,'neo.b@gmail.com','6045328786','neob123','v6j1k2','password123','Neo','Brown', 32),(3145,'ian.c@hotmail.ca','5867268876','ianc123','v7h1t4','password321','Ian','Castello', 17),(4713,'jill.b@live.ca','3765117825','jillb726','j6k9d0','pword123','Jill','Barber', 23),(71235,'pascal.h@gmail.com','2767825564','pascalb627','b8g6j2','passw123','Pascal','Huber', 27);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `startTime` varchar(45) NOT NULL,
  `endTIme` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `eid` varchar(45) NOT NULL,
  PRIMARY KEY (`eid`),
  CONSTRAINT `eid-event` FOREIGN KEY (`eid`) REFERENCES `performs` (`eid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES ('2022-03-02T20:15:29-05','2022-03-02T22:18:29-05','Jerry and Larry Comedy Night','1'),('2022-08-04T22:15:00-05','2022-08-09T00:00:00-05','Amy Schumer Saturday Standup','10'),('2022-02-02T16:12:29-05','2022-02-02T20:12:29-05','Lady Gaga Aspire @ Red Rocks','2'),('2021-07-13T18:12:29-05','2021-07-13T22:12:29-05','Ariana Grande Home Break @ Comodore Theatre','3'),('2019-04-18T18:12:29-05','2019-04-18T18:12:29-05','Jack Johnson Guitar Stories','4'),('2010-09-05T18:12:29-05','2010-09-05T22:12:29-05','Jerry Saturday Standup','5'),('2021-06-31T22:00:00-05','2021-06-31T23:00:00-05','Florida Georgia Line @ Thunderbird Stadium','6'),('2022-10-15T19:30:00-05','2022-10-15T21:15:30-05','Ryan Reynolds Showcase','7'),('2023-01-01T12:15:00-05','2023-01-01T14:15:45-05','Ariana Grande Tour','8'),('2015-06-17T23:30:30-05','2015-06-18T01:00:00-05','Jerry Seinfeld VIP Event','9');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostedat`
--

DROP TABLE IF EXISTS `hostedat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hostedat` (
  `eid` varchar(45) NOT NULL,
  `vid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `vid_idx` (`vid`),
  CONSTRAINT `eid-hosted` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE,
  CONSTRAINT `vid-hosted` FOREIGN KEY (`vid`) REFERENCES `venue` (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostedat`
--

LOCK TABLES `hostedat` WRITE;
/*!40000 ALTER TABLE `hostedat` DISABLE KEYS */;
INSERT INTO `hostedat` VALUES ('5','1'),('4','2'),('3','3'),('1','4'),('2','5');
/*!40000 ALTER TABLE `hostedat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicevent`
--

DROP TABLE IF EXISTS `musicevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musicevent` (
  `eid` varchar(45) NOT NULL,
  `liveSet` tinyint NOT NULL,
  `genre` varchar(45) NOT NULL,
  PRIMARY KEY (`eid`),
  CONSTRAINT `eid-music` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicevent`
--

LOCK TABLES `musicevent` WRITE;
/*!40000 ALTER TABLE `musicevent` DISABLE KEYS */;
INSERT INTO `musicevent` VALUES ('2',1,'Pop'),('3',1,'Pop'),('4',1,'Rock'),('6',1,'Country'),('8',0,'Pop');
/*!40000 ALTER TABLE `musicevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_table` (
  `eid` varchar(45) NOT NULL,
  `pid` varchar(45) NOT NULL,
  PRIMARY KEY (`eid`,`pid`),
  KEY `pid-performs_idx` (`pid`),
  CONSTRAINT `eid-performs` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`),
  CONSTRAINT `pid-performs` FOREIGN KEY (`pid`) REFERENCES `performer` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performer`
--

DROP TABLE IF EXISTS `performer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performer` (
  `stage_name` varchar(45) NOT NULL,
  `pid` varchar(45) NOT NULL,
  `industry` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile_number` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performer`
--

LOCK TABLES `performer` WRITE;
/*!40000 ALTER TABLE `performer` DISABLE KEYS */;
INSERT INTO `performer` VALUES ('Test','123123','Music','test@test.com','1203320120','test@test.com'),('Lady Gaga','2','Music','lgIsBoss@yahoo.net','643-234-1820','12093'),('Ariana Grande','3','Music','AriG@optonline.net','432-349-3902','12093'),('Jerry Seinfeld','4','Comedy','LarryDavidisBald@gmail.com','984-102-3203','19322'),('Larry David','5','Comedy','JerrySisAJerk@live.com','012-302-3496','12093'),('Florida Georgia Line','6','Music','Fgl123@hotmail.com','921-782-9021','50940'),('Ryan Reynolds','7','Comedy','RyanReynoldsComedy@reynolds.com','564-832-4320','29083'),('Amy Schumer','8','Comedy','Ams@yahoo.com','021-964-7476','78439'),('test','test','test','test','test','test'),('test','test123','test','test@test','test','test@test');
/*!40000 ALTER TABLE `performer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performs`
--

DROP TABLE IF EXISTS `performs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performs` (
  `eid` varchar(45) NOT NULL,
  `pid` varchar(45) NOT NULL,
  PRIMARY KEY (`eid`,`pid`),
  KEY `pid-performs_idx` (`pid`),
  CONSTRAINT `eid-perf` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE,
  CONSTRAINT `pid-perf` FOREIGN KEY (`pid`) REFERENCES `performer` (`pid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performs`
--

LOCK TABLES `performs` WRITE;
/*!40000 ALTER TABLE `performs` DISABLE KEYS */;
INSERT INTO `performs` VALUES ('2','2'),('3','3'),('8','3'),('1','4'),('5','4'),('9','4'),('1','5'),('4','5'),('6','6'),('7','7'),('10','8');
/*!40000 ALTER TABLE `performs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order` (
  `oid` varchar(50) NOT NULL,
  `num_tickets` int NOT NULL,
  `order_date` varchar(45) NOT NULL,
  `total_cost` decimal(10,0) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `username_idx` (`username`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `customer` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES ('123',2,'2022-03-02T20:15:29-05',90,'denpoly'),('124',1,'2022-02-28T20:15:29-05',45,'testUser1'),('182',1,'2022-02-27T20:15:29-05',90,'testUser1'),('423',1,'2022-01-29T20:15:29-05',45,'mattmemme'),('782',1,'2022-03-01T20:15:29-05',90,'mattmemme'),('83',1,'2022-03-09T20:15:29-05',90,'adamD102'),('1',6,'2022-03-10T20:15:29-05',270,'neob123'),('2',3,'2022-03-04T20:15:29-05',135,'ianc123'),('3',4,'2022-03-05T20:15:29-05',180,'jillb726'),('4',4,'2022-03-06T20:15:29-05',180,'pascalb627');
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `section` varchar(45) NOT NULL,
  `row` varchar(45) NOT NULL,
  `seat_code` varchar(45) NOT NULL,
  `cost` double NOT NULL,
  `vid` varchar(45) NOT NULL,
  PRIMARY KEY (`row`,`seat_code`,`vid`,`section`),
  KEY `vid-set_idx` (`vid`),
  CONSTRAINT `vid-set` FOREIGN KEY (`vid`) REFERENCES `venue` (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('GA','A','3A',45,'5'),('FLOOR','B','14B',90,'3'),('GA','C','4C',45,'2'),('FLOOR','E','12E',90,'1'),('FLOOR','E','13E',90,'4'),('FLOOR','Z','3Z',45,'4'),('FLOOR','Y','7Y',45,'4'),('FLOOR','X','33X',45,'4'),('FLOOR','W','12W',45,'4');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sponsor` (
  `logo` varchar(400) DEFAULT NULL,
  `is_company` tinyint NOT NULL,
  `address` varchar(100) NOT NULL,
  `sid` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `primary_phone` varchar(45) NOT NULL,
  `primary_email` varchar(45) NOT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `primary_email_UNIQUE` (`primary_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
INSERT INTO `sponsor` VALUES ('https://1000logos.net/wp-content/uploads/2017/05/Pepsi-Logo.png',1,'\"700 Anderson Hill Road','1','PepsiCo','914 253-2000','sponsorShip@pepsico.com'),('https://logos-download.com/wp-content/uploads/2016/03/Santander_logo_logotype_emblem.png',1,'\"Santander Consumer USA Inc.\nP.O. Box 961245\nFort Worth, TX 76161-1245\"','2','Santander','(800) 526-0157','eventTeam@santander.com'),('https://th.bing.com/th/id/R.d9f8e1b329d8b2bc479d8d429acf6527?rik=YDLL0NQ%2fBWjTrw&riu=http%3a%2f%2fwww.luisamarshall.com%2fkimi%2fwp-content%2fuploads%2f2013%2f11%2fCanadian-Red-Cross-Logo-2013.jpg&ehk=cRvtXqEtHxYuq%2b883mtCsb0Ag1V12RIuGiEpUYo%2frrU%3d&risl=&pid=ImgRaw&r=0',0,'105 7355 Canada Way, Burnaby BC V3N 4Z6','3','Canadian Red Cross','800-334-8434','events@redcrossca.com'),('https://th.bing.com/th/id/R.bd193aacc6c8a4562cd897b6ef8eda67?rik=N2hvWhJmvVdTng&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-coca-cola-logologobrand-logoiconslogos-251519939746cjaoy.png&ehk=lWB%2fhqYluz32Qq6TNPJ2iGSMvKAg%2fo0teT4yD1%2f%2fExA%3d&risl=&pid=ImgRaw&r=0',1,'14 -0082-0004-027, 1, Atlanta, Georgia, United States','4','Coca-Cola','800-293-9210','cokeEvents@cocacola.com'),('https://clipground.com/images/st-jude-logo-png-5.png',0,'262 Danny Thomas Pl, Memphis, TN 38105','5','St. Jude Children\'s Hospital','800-192-3920','frontDesk@stjudeHospital.org');
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsors`
--

DROP TABLE IF EXISTS `sponsors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sponsors` (
  `contractAllowance` double DEFAULT NULL,
  `sid` varchar(45) NOT NULL,
  `eid` varchar(45) NOT NULL,
  PRIMARY KEY (`sid`,`eid`),
  KEY `eid_idx` (`eid`),
  CONSTRAINT `eid` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE,
  CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `sponsor` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsors`
--

LOCK TABLES `sponsors` WRITE;
/*!40000 ALTER TABLE `sponsors` DISABLE KEYS */;
INSERT INTO `sponsors` VALUES (400000,'1','2'),(300000,'1','3'),(900000,'2','3'),(20000,'4','3'),(40000,'5','5');
/*!40000 ALTER TABLE `sponsors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `tid` varchar(50) NOT NULL,
  `eid` varchar(45) NOT NULL,
  `oid` varchar(45) DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `section` varchar(45) DEFAULT NULL,
  `row` varchar(45) DEFAULT NULL,
  `seat_code` varchar(45) DEFAULT NULL,
  `vid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `oid_idx` (`oid`),
  KEY `eid-ticket_idx` (`eid`),
  KEY `seat_idx` (`vid`,`seat_code`,`row`,`section`),
  CONSTRAINT `eid-ticket` FOREIGN KEY (`eid`) REFERENCES `event` (`eid`) ON DELETE CASCADE,
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `purchase_order` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES ('1','1','124',45,'GA','A','3A','1'),('2','5','423',45,'GA','C','4C','2'),('3','4','182',90,'Floor','E','12E','3'),('4','3','83',90,'Floor','B','14B','4'),('5','3','782',90,'Floor','E','12E','5'),('6','3','123',45,'B','B','11B','4'),('7','3','123',45,'D','D','9D','2'),('8','3','1',45,'Floor','Z','3Z','4'),('9','3','2',45,'Floor','Y','7Y','4'),('10','3','3',45,'Floor','X','33X','4'),('11','3','4',45,'Floor','W','12W','4');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venue` (
  `address` varchar(45) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `has_alcohol` tinyint NOT NULL,
  `has_food` tinyint NOT NULL,
  `is_outdoor` tinyint NOT NULL,
  `capacity` int NOT NULL,
  `vid` varchar(45) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`vid`),
  UNIQUE KEY `address_UNIQUE` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES ('18300 W Alameda Pkwy ','80465','Red Rocks Amphitheatre',1,1,1,8000,'1',500000),('421 High St','23704','Commodore Theatre',0,0,0,1000,'2',15000),('2601 Piedmont Ave','94704','Berkeley Stadium',0,1,1,15000,'3',330000),('6288 Stadium Rd','V6T 1Z3','Thunderbird Stadium',0,0,1,12000,'4',200000),('1660 Broadway E','V5N 1W1','Rio Theatre',1,1,0,1500,'5',30000);
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-25 13:24:52