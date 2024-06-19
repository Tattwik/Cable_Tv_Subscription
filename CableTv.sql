-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cable_tv_crud
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `provider_master`
--

DROP TABLE IF EXISTS `provider_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider_master` (
  `provider_id` int NOT NULL,
  `provider_name` varchar(45) NOT NULL,
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider_master`
--

LOCK TABLES `provider_master` WRITE;
/*!40000 ALTER TABLE `provider_master` DISABLE KEYS */;
INSERT INTO `provider_master` VALUES (101,'Sky View'),(102,'Ortel'),(103,'First TV');
/*!40000 ALTER TABLE `provider_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider_scbscription`
--

DROP TABLE IF EXISTS `provider_scbscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider_scbscription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `provider_id` int NOT NULL,
  `subscription_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p_id_fk2_idx` (`provider_id`),
  KEY `s_id_fk2_idx` (`subscription_id`),
  CONSTRAINT `p_id_fk2` FOREIGN KEY (`provider_id`) REFERENCES `provider_master` (`provider_id`),
  CONSTRAINT `s_id_fk2` FOREIGN KEY (`subscription_id`) REFERENCES `subscription_master` (`subscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider_scbscription`
--

LOCK TABLES `provider_scbscription` WRITE;
/*!40000 ALTER TABLE `provider_scbscription` DISABLE KEYS */;
INSERT INTO `provider_scbscription` VALUES (1,101,10),(2,101,20),(3,102,10),(4,102,20),(5,102,30),(6,103,20);
/*!40000 ALTER TABLE `provider_scbscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_details`
--

DROP TABLE IF EXISTS `registration_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration_details` (
  `registration_id` int NOT NULL AUTO_INCREMENT,
  `applicant_name` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `dob` date NOT NULL,
  `image_path` varchar(128) NOT NULL,
  `provider_id` int NOT NULL,
  `subscription_id` int NOT NULL,
  `is_delete` varchar(8) NOT NULL,
  PRIMARY KEY (`registration_id`),
  KEY `pro_id_fk12_idx` (`provider_id`),
  KEY `sub_id_fk12_idx` (`subscription_id`),
  CONSTRAINT `pro_id_fk12` FOREIGN KEY (`provider_id`) REFERENCES `provider_master` (`provider_id`),
  CONSTRAINT `sub_id_fk12` FOREIGN KEY (`subscription_id`) REFERENCES `subscription_master` (`subscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_details`
--

LOCK TABLES `registration_details` WRITE;
/*!40000 ALTER TABLE `registration_details` DISABLE KEYS */;
INSERT INTO `registration_details` VALUES (1,'Amit Das2','amit2@gmail.com','9876665654','male','2024-05-02','Deucative.txt',101,10,'NO'),(2,'Sumit Jena1','sumit@gmail.com','8654443432','male','2024-05-01','CarPurchase.zip',103,20,'NO'),(3,'Sunita Das','sunita@gamil.com','9861116414','female','2024-06-14','Deucative.txt',101,10,'NO'),(4,'Amit Das1','amit1@gmail.com','9876665699','male','2024-05-01','git_assessment_paper_talent_pool.docx',101,10,'YES');
/*!40000 ALTER TABLE `registration_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_master`
--

DROP TABLE IF EXISTS `subscription_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription_master` (
  `subscription_id` int NOT NULL,
  `subscription_type` varchar(45) NOT NULL,
  `fees` double NOT NULL,
  PRIMARY KEY (`subscription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_master`
--

LOCK TABLES `subscription_master` WRITE;
/*!40000 ALTER TABLE `subscription_master` DISABLE KEYS */;
INSERT INTO `subscription_master` VALUES (10,'1 Month',200),(20,'6 Month',1000),(30,'12 Month',1800);
/*!40000 ALTER TABLE `subscription_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-18 13:10:44
