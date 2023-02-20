CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `iata` varchar(3) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (252,'Barcelona','Spain','BCN','El prat'),(253,'Madrid','Spain','MAD','Barajas'),(254,'London','United Kingdom','LHR','Heathrow'),(255,'Paris','France','CDG','Charles de Gaulle'),(256,'Amsterdam','Netherlands','AMS','Schiphol');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport_seq`
--

DROP TABLE IF EXISTS `airport_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport_seq`
--

LOCK TABLES `airport_seq` WRITE;
/*!40000 ALTER TABLE `airport_seq` DISABLE KEYS */;
INSERT INTO `airport_seq` VALUES (351);
/*!40000 ALTER TABLE `airport_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew_member`
--

DROP TABLE IF EXISTS `crew_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew_member` (
  `id` bigint NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `job_position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew_member`
--

LOCK TABLES `crew_member` WRITE;
/*!40000 ALTER TABLE `crew_member` DISABLE KEYS */;
INSERT INTO `crew_member` VALUES (252,'Vueling','CM4568','Alex','Cremento','Pilot'),(253,'Vueling','CM9012','Pepita','Grillo','Copilot'),(254,'Ryanair','CM3456','Elva','Ginon','Cabin crew'),(255,'Ryanair','CM7890','Aitor','Menta','Cabin crew'),(256,'Vueling','CM1234','Alex','Cremento','Pilot');
/*!40000 ALTER TABLE `crew_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew_member_seq`
--

DROP TABLE IF EXISTS `crew_member_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew_member_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew_member_seq`
--

LOCK TABLES `crew_member_seq` WRITE;
/*!40000 ALTER TABLE `crew_member_seq` DISABLE KEYS */;
INSERT INTO `crew_member_seq` VALUES (351);
/*!40000 ALTER TABLE `crew_member_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` bigint NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `departure_date` datetime(6) DEFAULT NULL,
  `flight_code` varchar(255) DEFAULT NULL,
  `flight_duration` double DEFAULT NULL,
  `arrival_airport_id` bigint DEFAULT NULL,
  `departure_airport_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKor550l1m73innd911e6nm8lj0` (`arrival_airport_id`),
  KEY `FKillsy04237nltbk2yryrbderb` (`departure_airport_id`),
  KEY `FK7p9fvp6d7uh9cgn47uet8a8nb` (`plane_id`),
  CONSTRAINT `FK7p9fvp6d7uh9cgn47uet8a8nb` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKillsy04237nltbk2yryrbderb` FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKor550l1m73innd911e6nm8lj0` FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (252,'Vueling','2019-12-27 00:00:00.000000','VY2256',2,255,254,252),(253,'Ryanair','2019-11-13 00:00:00.000000','FR6589',2,253,252,252),(254,'TAP Portugal','2019-12-27 00:00:00.000000','TP1234',2,255,254,253);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_crew_member`
--

DROP TABLE IF EXISTS `flight_crew_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_crew_member` (
  `crew_member_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  PRIMARY KEY (`crew_member_id`,`flight_id`),
  KEY `FKka7r2ftkyq182ucnghr7if9ks` (`flight_id`),
  CONSTRAINT `FK7c82scvhxm2xsgmeaap0wf6wl` FOREIGN KEY (`crew_member_id`) REFERENCES `crew_member` (`id`),
  CONSTRAINT `FKka7r2ftkyq182ucnghr7if9ks` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_crew_member`
--

LOCK TABLES `flight_crew_member` WRITE;
/*!40000 ALTER TABLE `flight_crew_member` DISABLE KEYS */;
INSERT INTO `flight_crew_member` VALUES (252,252),(253,252),(254,253),(255,253),(256,254);
/*!40000 ALTER TABLE `flight_crew_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_seq`
--

DROP TABLE IF EXISTS `flight_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_seq`
--

LOCK TABLES `flight_seq` WRITE;
/*!40000 ALTER TABLE `flight_seq` DISABLE KEYS */;
INSERT INTO `flight_seq` VALUES (351);
/*!40000 ALTER TABLE `flight_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overhaul`
--

DROP TABLE IF EXISTS `overhaul`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overhaul` (
  `id` bigint NOT NULL,
  `overhaul_description` varchar(255) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `overhaul_type` varchar(255) DEFAULT NULL,
  `airport_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  `technician_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7spsq6vvs53evo06ujlni8st4` (`airport_id`),
  KEY `FK4u9u5nq20cb1rcubjg5howiwt` (`plane_id`),
  KEY `FKr6hn2y2xk453oh6k1xjvan7b3` (`technician_id`),
  CONSTRAINT `FK4u9u5nq20cb1rcubjg5howiwt` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FK7spsq6vvs53evo06ujlni8st4` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKr6hn2y2xk453oh6k1xjvan7b3` FOREIGN KEY (`technician_id`) REFERENCES `technician` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overhaul`
--

LOCK TABLES `overhaul` WRITE;
/*!40000 ALTER TABLE `overhaul` DISABLE KEYS */;
INSERT INTO `overhaul` VALUES (252,'Description',15,'2019-04-17 00:00:00.000000','2019-04-15 00:00:00.000000','Periodical',252,252,252),(253,'Description',30,'2019-07-18 00:00:00.000000','2019-07-15 00:00:00.000000','Periodical',253,252,253),(254,'Description',10,'2019-12-18 00:00:00.000000','2019-12-15 00:00:00.000000','Extraordinary',254,253,254),(255,'Description',50,'2019-09-18 00:00:00.000000','2019-09-15 00:00:00.000000','Periodical',255,253,255);
/*!40000 ALTER TABLE `overhaul` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overhaul_seq`
--

DROP TABLE IF EXISTS `overhaul_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overhaul_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overhaul_seq`
--

LOCK TABLES `overhaul_seq` WRITE;
/*!40000 ALTER TABLE `overhaul_seq` DISABLE KEYS */;
INSERT INTO `overhaul_seq` VALUES (351);
/*!40000 ALTER TABLE `overhaul_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plane`
--

DROP TABLE IF EXISTS `plane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plane` (
  `id` bigint NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `number_of_flight_hours` bigint NOT NULL,
  `plate_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g2w3381o6f6budn5dvyk4j0ru` (`plate_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plane`
--

LOCK TABLES `plane` WRITE;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` VALUES (252,'Boeing','747',5000,'1234'),(253,'Airbus','A380',10000,'5678'),(254,'Airbus','A330',15000,'9876'),(255,'Boeing','737',20000,'5432'),(256,'Airbus','A320',20000,'1111');
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plane_seq`
--

DROP TABLE IF EXISTS `plane_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plane_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plane_seq`
--

LOCK TABLES `plane_seq` WRITE;
/*!40000 ALTER TABLE `plane_seq` DISABLE KEYS */;
INSERT INTO `plane_seq` VALUES (351);
/*!40000 ALTER TABLE `plane_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technician`
--

DROP TABLE IF EXISTS `technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technician` (
  `id` bigint NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `start_year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` VALUES (252,'Vueling','AF1234','John','Doe','High',2012),(253,'Vueling','AF5678','Jane','Doe','University',2013),(254,'Ryanair','AF9012','John','Smith','Primary',2014),(255,'TAP Portugal','AF3456','Jane','Smith','Secondary',2015);
/*!40000 ALTER TABLE `technician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technician_seq`
--

DROP TABLE IF EXISTS `technician_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technician_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician_seq`
--

LOCK TABLES `technician_seq` WRITE;
/*!40000 ALTER TABLE `technician_seq` DISABLE KEYS */;
INSERT INTO `technician_seq` VALUES (351);
/*!40000 ALTER TABLE `technician_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-20 17:04:05
