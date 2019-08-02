create database `taxi_database`;

use `taxi_database`;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `adress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adress` (
  `id_adress` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(128) NOT NULL,
  `house_number` varchar(12) NOT NULL,
  PRIMARY KEY (`id_adress`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `adress` WRITE;
/*!40000 ALTER TABLE `adress` DISABLE KEYS */;
INSERT INTO `adress` VALUES (1,'Янгеля','12'),(2,'Янгеля','16/2'),(3,'Янгеля','7'),(4,'Янгеля','8'),(5,'Проскурівська','3'),(6,'Проскурівська','4'),(7,'Андріївська','7'),(8,'Андріївська','8'),(9,'Петровська','12'),(10,'Петровська','55');
/*!40000 ALTER TABLE `adress` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `car` (
  `id_car` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `car_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id_car`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'BX3490VC','Audi','blue','wagon'),(2,'AA4533AM','BMW','yellow','wagon'),(3,'AA4544AM','Mercedes','white','minivan'),(4,'BX2093MX','Lada','black','light'),(5,'AA8789AM','BMV','blue','light'),(6,'AZ2323AK','Shkoda','black','light'),(7,'AM2378AM','Audi','white','wagon');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 16:36:05


-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client` (
  `id_client` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `surname` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `phone_number` varchar(13) NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `e-mail_UNIQUE` (`e_mail`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Шемелюк','Орест','+380976970365','orestshemelyuk@gmail.com','rootroot'),(2,'Щур','Назар','+380953523320','nazar34shcher@gmail.com','nazar12'),(3,'Велігоненко','Сергій','+380978324722','veligonenko33@gmail.com','velik45'),(4,'Роєнко','Олександр','+380967825532','roenko_olexandr@gmail.com','roenko34'),(5,'Бортнічук','Нікіта','+380452366623','titanikborta@gmail.com','bortik22'),(6,'Сторожук','Констянтин','+380923422237','storozhuk33@gmail.com','storozh1'),(10,'Якобчук','Андрій','+380433423452','andriyyakobchuk@gmail.com','andriy12'),(29,'Микола','Назар','+380961248850','joy0@spaces.ru','qwerty123'),(31,'Петро','Гость','+380976970363','orestsheme3k@gmail.com','qwertyu');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 16:36:04

-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coupon` (
  `id_coupon` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(45) NOT NULL,
  `discount` int(10) NOT NULL,
  PRIMARY KEY (`id_coupon`),
  UNIQUE KEY `coupon_UNIQUE` (`coupon_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'AZAZ',20),(2,'TAXIKYIV',10),(3,'TAKITAKI',40),(4,'KUPON',20);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 16:36:05

-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver` (
  `id_driver` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `surname` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `middle_name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `phone_number` varchar(14) NOT NULL,
  `driver_status` varchar(45) NOT NULL,
  `id_car` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_driver`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  KEY `fk_driver_car_idx` (`id_car`),
  CONSTRAINT `fk_driver_car` FOREIGN KEY (`id_car`) REFERENCES `car` (`id_car`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'Карпенко','Андрій','Олександрович','qwerty','+380983445123','free',1),(2,'Пацевко','Олена','Ігорівна','asdfgh','+380923454352','free',2),(3,'Арутунян','Ерік','Андрійович','applepen','+380983453432','booked',4),(4,'Іванюк','Андрій','Олегович','aplea1','+380923454623','booked',3),(5,'Кириченко','Євгеній','Назарович','123456789','+380923423112','booked',5),(6,'Сусоєв','Максим','Васильович','888888888','+380932345633','free',7),(7,'Голуб','Віталій','Сергійович','qazwsxedcrfv','+380965423232','free',6);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 16:36:06

-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taxi_database
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `id_order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_status` varchar(45) NOT NULL,
  `id_client` int(10) unsigned NOT NULL,
  `id_driver` int(10) unsigned DEFAULT NULL,
  `id_adress_departure` int(10) unsigned NOT NULL,
  `id_adress_arrive` int(10) unsigned NOT NULL,
  `id_coupon` int(10) unsigned DEFAULT NULL,
  `cost` double unsigned NOT NULL,
  `cost_with_discount` double unsigned NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_order_client1_idx` (`id_client`),
  KEY `fk_order_coupon1_idx` (`id_coupon`),
  KEY `fk_order_adress2_idx` (`id_adress_departure`),
  KEY `fk_order_driver1_idx1` (`id_driver`),
  KEY `fk_order_adress3_idx` (`id_adress_arrive`),
  CONSTRAINT `fk_order_adress2` FOREIGN KEY (`id_adress_departure`) REFERENCES `adress` (`id_adress`),
  CONSTRAINT `fk_order_adress3` FOREIGN KEY (`id_adress_arrive`) REFERENCES `adress` (`id_adress`),
  CONSTRAINT `fk_order_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  CONSTRAINT `fk_order_coupon1` FOREIGN KEY (`id_coupon`) REFERENCES `coupon` (`id_coupon`),
  CONSTRAINT `fk_order_driver1` FOREIGN KEY (`id_driver`) REFERENCES `driver` (`id_driver`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (4,'COMPLETE',3,1,1,4,1,100,90),(5,'COMPLETE',2,1,3,2,NULL,100,100),(6,'COMPLETE',4,2,4,5,2,120,100),(7,'COMPLETE',2,3,3,4,NULL,120,120),(10,'COMPLETE',2,1,3,6,1,120,100),(14,'COMPLETE',4,3,2,4,2,360,230),(15,'COMPLETE',5,2,1,5,NULL,260,260),(24,'COMPLETE',2,4,4,3,NULL,120,100),(38,'COMPLETE',1,3,3,1,NULL,265,238),(39,'COMPLETE',1,5,5,1,NULL,314,282),(40,'COMPLETE',1,4,1,7,NULL,278,250),(41,'COMPLETE',1,7,1,7,NULL,266,239),(42,'COMPLETE',1,1,4,1,NULL,332,298),(43,'COMPLETE',1,3,4,1,NULL,309,278),(44,'COMPLETE',1,5,1,10,NULL,289,260),(45,'COMPLETE',1,7,3,1,NULL,285,256),(46,'COMPLETE',1,1,6,1,NULL,321,288),(47,'COMPLETE',1,3,2,1,NULL,253,227),(48,'COMPLETE',1,5,2,1,NULL,274,246),(49,'COMPLETE',1,7,1,8,NULL,285,256),(50,'COMPLETE',1,4,1,3,1,243,194),(51,'COMPLETE',1,1,4,1,NULL,295,265),(52,'COMPLETE',1,1,1,10,1,356,255),(53,'COMPLETE',1,1,4,1,NULL,251,225),(54,'COMPLETE',1,1,7,1,NULL,328,295),(55,'COMPLETE',1,1,7,1,NULL,326,293),(56,'COMPLETE',1,1,6,1,NULL,289,260),(57,'COMPLETE',1,1,1,8,NULL,279,251),(58,'COMPLETE',1,3,7,1,NULL,249,224),(59,'COMPLETE',1,5,1,3,NULL,267,240),(60,'COMPLETE',1,1,5,1,NULL,230,207),(61,'COMPLETE',1,2,4,1,NULL,261,234),(62,'COMPLETE',1,4,7,1,NULL,289,260),(63,'COMPLETE',1,3,1,8,NULL,303,272),(64,'COMPLETE',1,5,4,1,NULL,315,283),(65,'COMPLETE',1,7,10,1,NULL,300,270),(66,'COMPLETE',1,4,4,1,NULL,298,268),(67,'COMPLETE',1,1,6,1,NULL,235,211),(68,'COMPLETE',1,2,9,1,NULL,261,234),(69,'COMPLETE',1,3,8,2,1,245,196),(70,'COMPLETE',1,5,5,1,NULL,256,230),(71,'COMPLETE',2,1,2,1,NULL,321,288),(72,'COMPLETE',1,7,6,3,1,297,213),(73,'COMPLETE',1,3,9,2,3,330,198),(74,'COMPLETE',1,4,10,7,1,284,204),(75,'COMPLETE',1,1,9,6,1,323,232),(81,'COMPLETE',1,3,10,2,1,286,205),(82,'COMPLETE',1,4,5,1,NULL,326,293),(83,'COMPLETE',31,5,9,4,NULL,274,219);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-13 16:36:06
