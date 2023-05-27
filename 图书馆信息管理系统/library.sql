CREATE DATABASE  IF NOT EXISTS `book_schema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `book_schema`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: book_schema
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
-- Table structure for table `book_table`
--

DROP TABLE IF EXISTS `book_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_table` (
  `book_number` char(13) NOT NULL,
  `book_name` char(64) NOT NULL,
  `book_writer` char(64) NOT NULL,
  `book_publishingHouse` char(64) NOT NULL,
  `book_publishingDate` date NOT NULL,
  `book_category` char(9) NOT NULL,
  `book_callNumber` char(10) NOT NULL,
  `book_floor` char(1) NOT NULL,
  `bookrack` char(2) NOT NULL,
  `book_state` char(2) NOT NULL,
  `book_readerNumber` char(12) DEFAULT NULL,
  `book_borrowDate` date DEFAULT NULL,
  `book_renewDate` date DEFAULT NULL,
  `book_returnDate` date DEFAULT NULL,
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_table`
--

LOCK TABLES `book_table` WRITE;
/*!40000 ALTER TABLE `book_table` DISABLE KEYS */;
INSERT INTO `book_table` VALUES ('H12345.100.01','Python3.5','刘宇宙','清华大学出版社','2001-01-01','语言','H12345.100','2','9','损坏',NULL,NULL,NULL,NULL),('H12345.100.02','Python3.5','刘宇宙','清华大学出版社','2011-01-01','语言','H12345.100','2','9','可借',NULL,NULL,NULL,NULL),('H12345.100.03','Python3.5','刘宇宙','清华大学出版社','2017-01-01','语言','H12345.100','2','9','可借',NULL,NULL,NULL,NULL),('H12345.101.01','工程光学','欧阳光中','清华大学出版社','1980-01-01','语言','H12345.101','2','8','可借',NULL,NULL,NULL,NULL),('H12345.101.02','工程光学','欧阳光中','清华大学出版社','1990-01-01','语言','H12345.101','2','8','可借',NULL,NULL,NULL,NULL),('H12345.101.03','工程光学','欧阳光中','清华大学出版社','2000-01-01','语言','H12345.101','2','8','损坏',NULL,NULL,NULL,NULL),('H12345.101.04','工程光学','欧阳光中','清华大学出版社','2010-01-01','语言','H12345.101','2','8','可借',NULL,NULL,NULL,NULL),('H12345.101.05','工程光学','欧阳光中','清华大学出版社','2020-01-01','语言','H12345.101','2','8','可借',NULL,NULL,NULL,NULL),('H12345.123.01','标准日本语','欧阳光中','人民教育出版社','2005-02-01','语言','H12345.123','2','11','可借',NULL,NULL,NULL,NULL),('H12345.123.02','标准日本语','欧阳光中','人民教育出版社','1998-01-01','语言','H12345.123','2','11','可借',NULL,NULL,NULL,NULL),('H12345.123.03','标准日本语','欧阳光中','人民教育出版社','2005-02-01','语言','H12345.123','2','11','可借',NULL,NULL,NULL,NULL),('H12345.124.01','研究生英语','刘宇宙','人民教育出版社','2005-02-01','语言','H12345.124','2','7','损坏',NULL,NULL,NULL,NULL),('H12345.124.02','研究生英语','刘宇宙','人民教育出版社','2008-01-01','语言','H12345.124','2','7','可借',NULL,NULL,NULL,NULL),('H12345.124.03','研究生英语','刘宇宙','人民教育出版社','2018-01-01','语言','H12345.124','2','7','可借',NULL,NULL,NULL,NULL),('H12345.124.04','研究生英语','刘宇宙','人民教育出版社','2005-02-01','语言','H12345.124','2','7','可借',NULL,NULL,NULL,NULL),('H12345.124.05','研究生英语','刘宇宙','人民教育出版社','1998-01-01','语言','H12345.124','2','7','可借',NULL,NULL,NULL,NULL),('O11111.110.01','傅里叶光学','吕乃光','清华大学出版社','1988-01-01','数理科学和化学','O11111.110','1','10','可借',NULL,NULL,NULL,NULL),('O11111.110.02','傅里叶光学','吕乃光','清华大学出版社','1978-01-01','数理科学和化学','O11111.110','1','10','可借',NULL,NULL,NULL,NULL),('O11111.110.03','傅里叶光学','吕乃光','清华大学出版社','1998-01-01','数理科学和化学','O11111.110','1','10','可借',NULL,NULL,NULL,NULL),('O11111.110.04','傅里叶光学','吕乃光','清华大学出版社','2008-01-01','数理科学和化学','O11111.110','1','10','可借',NULL,NULL,NULL,NULL),('O11111.110.05','傅里叶光学','吕乃光','清华大学出版社','2018-01-01','数理科学和化学','O11111.110','1','10','可借',NULL,NULL,NULL,NULL),('O11111.111.01','数学分析','欧阳光中','复旦大学出版社','2007-01-01','数理科学和化学','O11111.111','1','13','可借',NULL,NULL,NULL,NULL),('O11111.111.02','数学分析','欧阳光中','复旦大学出版社','2018-01-01','数理科学和化学','O11111.111','1','13','可借',NULL,NULL,NULL,NULL),('O11111.111.03','数学分析','欧阳光中','复旦大学出版社','1978-01-01','数理科学和化学','O11111.111','1','13','损坏',NULL,NULL,NULL,NULL),('O11111.111.04','数学分析','欧阳光中','复旦大学出版社','2014-01-01','数理科学和化学','O11111.111','1','13','可借',NULL,NULL,NULL,NULL),('O11111.111.05','数学分析','欧阳光中','复旦大学出版社','2007-01-01','数理科学和化学','O11111.111','1','13','可借',NULL,NULL,NULL,NULL),('O11111.112.01','大学物理','吕乃光','人民教育出版社','1998-01-01','数理科学和化学','O11111.112','1','14','可借',NULL,NULL,NULL,NULL),('O11111.112.02','大学物理','吕乃光','人民教育出版社','2009-01-01','数理科学和化学','O11111.112','1','14','可借',NULL,NULL,NULL,NULL),('O11111.112.03','大学物理','吕乃光','人民教育出版社','2019-01-01','数理科学和化学','O11111.112','1','14','可借',NULL,NULL,NULL,NULL),('O11111.113.01','数值分析','刘宇宙','复旦大学出版社','1988-01-01','数理科学和化学','O11111.113','1','15','可借',NULL,NULL,NULL,NULL),('O11111.113.02','数值分析','刘宇宙','复旦大学出版社','2008-01-01','数理科学和化学','O11111.113','1','15','损坏',NULL,NULL,NULL,NULL),('O11111.113.03','数值分析','刘宇宙','复旦大学出版社','2014-01-01','数理科学和化学','O11111.113','1','15','可借',NULL,NULL,NULL,NULL),('O11111.113.04','数值分析','刘宇宙','复旦大学出版社','2008-01-01','数理科学和化学','O11111.113','1','15','可借',NULL,NULL,NULL,NULL),('O11111.113.05','数值分析','刘宇宙','复旦大学出版社','2005-02-01','数理科学和化学','O11111.113','1','15','可借',NULL,NULL,NULL,NULL),('O11111.114.01','实变函数','欧阳光中','人民教育出版社','1998-01-01','数理科学和化学','O11111.114','1','16','可借',NULL,NULL,NULL,NULL),('O11111.114.02','实变函数','欧阳光中','人民教育出版社','2005-02-01','数理科学和化学','O11111.114','1','16','可借',NULL,NULL,NULL,NULL),('O11111.114.03','实变函数','欧阳光中','人民教育出版社','2018-01-01','数理科学和化学','O11111.114','1','16','可借',NULL,NULL,NULL,NULL),('O11111.114.04','实变函数','欧阳光中','人民教育出版社','1998-01-01','数理科学和化学','O11111.114','1','16','可借',NULL,NULL,NULL,NULL),('O11111.114.05','实变函数','欧阳光中','人民教育出版社','2008-01-01','数理科学和化学','O11111.114','1','16','可借',NULL,NULL,NULL,NULL),('O11111.115.01','高等代数','吕乃光','复旦大学出版社','2005-02-01','数理科学和化学','O11111.115','1','17','可借',NULL,NULL,NULL,NULL),('O11111.115.02','高等代数','吕乃光','复旦大学出版社','1998-01-01','数理科学和化学','O11111.115','1','17','可借',NULL,NULL,NULL,NULL),('O11111.115.03','高等代数','吕乃光','复旦大学出版社','2018-01-01','数理科学和化学','O11111.115','1','17','可借',NULL,NULL,NULL,NULL),('O11111.115.04','高等代数','吕乃光','复旦大学出版社','1988-01-01','数理科学和化学','O11111.115','1','17','可借',NULL,NULL,NULL,NULL),('O11111.115.05','高等代数','吕乃光','复旦大学出版社','2008-01-01','数理科学和化学','O11111.115','1','17','可借',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-23 20:40:56
CREATE DATABASE  IF NOT EXISTS `reader_schema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reader_schema`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: reader_schema
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
-- Table structure for table `reader_total_table`
--

DROP TABLE IF EXISTS `reader_total_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reader_total_table` (
  `reader_number` char(12) NOT NULL,
  `reader_password` char(16) NOT NULL,
  `reader_name` char(6) NOT NULL,
  `reader_gender` char(1) NOT NULL,
  `reader_qualifications` char(5) NOT NULL,
  `reader_major` char(16) NOT NULL,
  `reader_grade` char(3) NOT NULL,
  `reader_ admissionTime` date NOT NULL,
  `reader_organization` char(16) NOT NULL,
  `reader_state` char(2) NOT NULL,
  `borrow_maxNum` char(2) NOT NULL,
  `borrow_num` char(2) NOT NULL,
  `borrow_bookNumbers` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`reader_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader_total_table`
--

LOCK TABLES `reader_total_table` WRITE;
/*!40000 ALTER TABLE `reader_total_table` DISABLE KEYS */;
INSERT INTO `reader_total_table` VALUES ('12345678','12345678','张三','男','本科','软件工程','三年级','2020-09-01','信息学院','正常','15','0',NULL);
/*!40000 ALTER TABLE `reader_total_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-23 20:40:56
CREATE DATABASE  IF NOT EXISTS `administrator_schema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `administrator_schema`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: administrator_schema
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
-- Table structure for table `administrator_table`
--

DROP TABLE IF EXISTS `administrator_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator_table` (
  `administrator_account` varchar(20) NOT NULL,
  `administrator_attribute` char(2) NOT NULL,
  `administrator_password` char(16) NOT NULL,
  `administrator_passwordQuestion` varchar(32) DEFAULT NULL,
  `administrator_passwordAnswer` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`administrator_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator_table`
--

LOCK TABLES `administrator_table` WRITE;
/*!40000 ALTER TABLE `administrator_table` DISABLE KEYS */;
INSERT INTO `administrator_table` VALUES ('12345','超管','12345',NULL,NULL);
/*!40000 ALTER TABLE `administrator_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-23 20:40:56
