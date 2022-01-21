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
-- Table structure for table `tbl_user_pharmacist_login`
--

DROP TABLE IF EXISTS `tbl_user_pharmacist_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user_pharmacist_login` (
  `pms_pharmacist_log_id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `pms_pharmacist_email` varchar(255) DEFAULT NULL,
  `pms_pharmacist_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pms_pharmacist_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_pharmacist_login`
--

LOCK TABLES `tbl_user_pharmacist_login` WRITE;
/*!40000 ALTER TABLE `tbl_user_pharmacist_login` DISABLE KEYS */;
INSERT INTO `tbl_user_pharmacist_login` VALUES (1,'ROLE_PHARMACIST',_binary '','we@gmail.com','$2a$10$MspWGkOk0Ku2acDU9vGuW.znyg/4/P0Y3F4d277mWTdnI32SdHnFG'),(3,'ROLE_PHARMACIST',_binary '','tikiri@gmail.com','$2a$10$XZzhj8vXGwMgWfNYWXlqmuQF13zAoBnh248wNVBKCBDyOQFZ44tL6'),(5,'ROLE_PHARMACIST',_binary '','indra@gmail.com','$2a$10$m26pR26BqJW3IKkj8Y7FVeMLCX3SxuCblqh2ysiheFWbygHs1xunq');
/*!40000 ALTER TABLE `tbl_user_pharmacist_login` ENABLE KEYS */;
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
