-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eea_pms_new_db
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
-- Table structure for table `drugs_items`
--

DROP TABLE IF EXISTS `drugs_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drugs_items` (
  `drug_id` int NOT NULL,
  `drug_name` varchar(255) NOT NULL,
  `full_quantity` int NOT NULL,
  `price` float NOT NULL,
  `itm_brand_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`drug_id`),
  KEY `FKaxx7ifqqtuylg7978bb89lx27` (`itm_brand_id`),
  KEY `FKbiljt0qvaxk8nddhu3oyiba2a` (`category_id`),
  CONSTRAINT `FKaxx7ifqqtuylg7978bb89lx27` FOREIGN KEY (`itm_brand_id`) REFERENCES `tbl_pms_item_brand` (`itm_brand_id`),
  CONSTRAINT `FKbiljt0qvaxk8nddhu3oyiba2a` FOREIGN KEY (`category_id`) REFERENCES `tbl_pms_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugs_items`
--

LOCK TABLES `drugs_items` WRITE;
/*!40000 ALTER TABLE `drugs_items` DISABLE KEYS */;
INSERT INTO `drugs_items` VALUES (7,'Amoxicillin capsule',122,50,2,1),(10,'Amoxicillin capsule',11,20,6,9),(11,'Vitamin C',100,5000,6,1);
/*!40000 ALTER TABLE `drugs_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-21  8:13:36
