-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: servicestation
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `affilate_has_orders`
--

DROP TABLE IF EXISTS `affilate_has_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_has_orders` (
  `affilate_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `order_id_idx` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_has_orders`
--

LOCK TABLES `affilate_has_orders` WRITE;
/*!40000 ALTER TABLE `affilate_has_orders` DISABLE KEYS */;
INSERT INTO `affilate_has_orders` VALUES (2,1);
/*!40000 ALTER TABLE `affilate_has_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_has_part_orders_persons`
--

DROP TABLE IF EXISTS `affilate_has_part_orders_persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_has_part_orders_persons` (
  `affilate_id` int(11) NOT NULL,
  `part_order_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`part_order_id`),
  UNIQUE KEY `part_order_id_UNIQUE` (`part_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_has_part_orders_persons`
--

LOCK TABLES `affilate_has_part_orders_persons` WRITE;
/*!40000 ALTER TABLE `affilate_has_part_orders_persons` DISABLE KEYS */;
INSERT INTO `affilate_has_part_orders_persons` VALUES (2,1,1);
/*!40000 ALTER TABLE `affilate_has_part_orders_persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_has_parts_counts`
--

DROP TABLE IF EXISTS `affilate_has_parts_counts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_has_parts_counts` (
  `affilate_id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`affilate_id`,`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_has_parts_counts`
--

LOCK TABLES `affilate_has_parts_counts` WRITE;
/*!40000 ALTER TABLE `affilate_has_parts_counts` DISABLE KEYS */;
INSERT INTO `affilate_has_parts_counts` VALUES (2,1,33);
/*!40000 ALTER TABLE `affilate_has_parts_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_has_persons`
--

DROP TABLE IF EXISTS `affilate_has_persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_has_persons` (
  `affilate_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_has_persons`
--

LOCK TABLES `affilate_has_persons` WRITE;
/*!40000 ALTER TABLE `affilate_has_persons` DISABLE KEYS */;
INSERT INTO `affilate_has_persons` VALUES (2,1);
/*!40000 ALTER TABLE `affilate_has_persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_has_services_costs`
--

DROP TABLE IF EXISTS `affilate_has_services_costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_has_services_costs` (
  `affilate_id` int(11) NOT NULL,
  `sevice_id` int(11) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`affilate_id`,`sevice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_has_services_costs`
--

LOCK TABLES `affilate_has_services_costs` WRITE;
/*!40000 ALTER TABLE `affilate_has_services_costs` DISABLE KEYS */;
INSERT INTO `affilate_has_services_costs` VALUES (2,1,15);
/*!40000 ALTER TABLE `affilate_has_services_costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_profile_has_dates_rent`
--

DROP TABLE IF EXISTS `affilate_profile_has_dates_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_profile_has_dates_rent` (
  `affilate_profile_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `rent` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`affilate_profile_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_profile_has_dates_rent`
--

LOCK TABLES `affilate_profile_has_dates_rent` WRITE;
/*!40000 ALTER TABLE `affilate_profile_has_dates_rent` DISABLE KEYS */;
INSERT INTO `affilate_profile_has_dates_rent` VALUES (2,'2015-02-01',100),(2,'2015-12-01',100);
/*!40000 ALTER TABLE `affilate_profile_has_dates_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_profiles`
--

DROP TABLE IF EXISTS `affilate_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_profiles` (
  `affilate_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`affilate_profile_id`),
  UNIQUE KEY `affilate_profile_id_UNIQUE` (`affilate_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_profiles`
--

LOCK TABLES `affilate_profiles` WRITE;
/*!40000 ALTER TABLE `affilate_profiles` DISABLE KEYS */;
INSERT INTO `affilate_profiles` VALUES (1);
/*!40000 ALTER TABLE `affilate_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilates`
--

DROP TABLE IF EXISTS `affilates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilates` (
  `affilate_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_affilate_id` varchar(45) NOT NULL,
  PRIMARY KEY (`affilate_id`),
  UNIQUE KEY `affilate_id_UNIQUE` (`affilate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilates`
--

LOCK TABLES `affilates` WRITE;
/*!40000 ALTER TABLE `affilates` DISABLE KEYS */;
INSERT INTO `affilates` VALUES (1,'NULL'),(2,'altufievo');
/*!40000 ALTER TABLE `affilates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_notifications`
--

DROP TABLE IF EXISTS `client_notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_notifications` (
  `client_notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_notification` varchar(1024) NOT NULL,
  PRIMARY KEY (`client_notification_id`),
  UNIQUE KEY `client_notification_id_UNIQUE` (`client_notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_notifications`
--

LOCK TABLES `client_notifications` WRITE;
/*!40000 ALTER TABLE `client_notifications` DISABLE KEYS */;
INSERT INTO `client_notifications` VALUES (1,'Выполнение заказа переносится на неопределённый срок. Ожидаем запчастей.');
/*!40000 ALTER TABLE `client_notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `site_user_id` int(11) NOT NULL,
  `visible` bit(1) NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `comment_id_UNIQUE` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Удобная станция. Советую.','2015-08-02',2,''),(2,'Грамотный специалист. Рекомендую.','2015-08-02',3,'');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logginers`
--

DROP TABLE IF EXISTS `logginers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logginers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`name`,`login`,`role`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logginers`
--

LOCK TABLES `logginers` WRITE;
/*!40000 ALTER TABLE `logginers` DISABLE KEYS */;
INSERT INTO `logginers` VALUES (1,'Петрович','petrovich','petrovich','MECHANIC'),(2,'Петя','pit','pit','USER'),(3,'Боря','boris','boris','USER'),(4,'Иваныч','ivanych','ivanych','MECHANIC');
/*!40000 ALTER TABLE `logginers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `mark_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `date` date NOT NULL,
  `site_user_id` int(11) NOT NULL,
  PRIMARY KEY (`mark_id`),
  UNIQUE KEY `mark_id_UNIQUE` (`mark_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,4,'2015-08-02',2);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanic_profile_has_comments`
--

DROP TABLE IF EXISTS `mechanic_profile_has_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mechanic_profile_has_comments` (
  `mechanic_profile_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `comment_id_UNIQUE` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic_profile_has_comments`
--

LOCK TABLES `mechanic_profile_has_comments` WRITE;
/*!40000 ALTER TABLE `mechanic_profile_has_comments` DISABLE KEYS */;
INSERT INTO `mechanic_profile_has_comments` VALUES (1,2);
/*!40000 ALTER TABLE `mechanic_profile_has_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanic_profiles`
--

DROP TABLE IF EXISTS `mechanic_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mechanic_profiles` (
  `mechanic_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mechanic_profile_id`),
  UNIQUE KEY `mechanic_profile_id_UNIQUE` (`mechanic_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic_profiles`
--

LOCK TABLES `mechanic_profiles` WRITE;
/*!40000 ALTER TABLE `mechanic_profiles` DISABLE KEYS */;
INSERT INTO `mechanic_profiles` VALUES (1);
/*!40000 ALTER TABLE `mechanic_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_has_parts_counts`
--

DROP TABLE IF EXISTS `order_has_parts_counts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_has_parts_counts` (
  `order_id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_parts_counts`
--

LOCK TABLES `order_has_parts_counts` WRITE;
/*!40000 ALTER TABLE `order_has_parts_counts` DISABLE KEYS */;
INSERT INTO `order_has_parts_counts` VALUES (1,1,2);
/*!40000 ALTER TABLE `order_has_parts_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_has_services`
--

DROP TABLE IF EXISTS `order_has_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_has_services` (
  `order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_services`
--

LOCK TABLES `order_has_services` WRITE;
/*!40000 ALTER TABLE `order_has_services` DISABLE KEYS */;
INSERT INTO `order_has_services` VALUES (1,1);
/*!40000 ALTER TABLE `order_has_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_has_services_costs`
--

DROP TABLE IF EXISTS `order_has_services_costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_has_services_costs` (
  `order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `cost` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_services_costs`
--

LOCK TABLES `order_has_services_costs` WRITE;
/*!40000 ALTER TABLE `order_has_services_costs` DISABLE KEYS */;
INSERT INTO `order_has_services_costs` VALUES (1,1,12);
/*!40000 ALTER TABLE `order_has_services_costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_status` varchar(45) NOT NULL,
  `order_create_date` date NOT NULL,
  `order_compleate_date` date DEFAULT '0000-00-00',
  `order_problem_description` varchar(256) DEFAULT NULL,
  `client_notification_id` int(11) DEFAULT NULL,
  `client_order_id` varchar(45) DEFAULT 'NOTSET',
  `order_contact_data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'NEW','2015-08-01',NULL,'Сильная вибрация при скорости больше 80 км//ч',1,NULL,NULL),(12,'NEW','2015-08-10',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(13,'NEW','2015-08-10',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(14,'NEW','2015-08-10',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(15,'NEW','2015-08-10',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(16,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(18,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(19,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(20,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(21,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(22,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(23,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(24,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(25,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(26,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(27,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(28,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(29,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(30,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(31,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(32,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(33,'NEW','2015-08-11',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(34,'NEW','2015-08-12',NULL,'потеют стёкла',NULL,NULL,'Поповича 2Б'),(35,'NEW','2015-08-14',NULL,'ÐÑÐ¾Ð±Ð»ÐµÐ¼Ñ Ñ ÐºÐ¾Ð´Ð¸ÑÐ¾Ð²ÐºÐ¾Ð¹',NULL,NULL,'ÐÐ¾Ð¼ Ñ Ð¾Ð·ÐµÑÐ°');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_order_has_parts_counts`
--

DROP TABLE IF EXISTS `part_order_has_parts_counts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_order_has_parts_counts` (
  `part_order_id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`part_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_order_has_parts_counts`
--

LOCK TABLES `part_order_has_parts_counts` WRITE;
/*!40000 ALTER TABLE `part_order_has_parts_counts` DISABLE KEYS */;
INSERT INTO `part_order_has_parts_counts` VALUES (1,1,2);
/*!40000 ALTER TABLE `part_order_has_parts_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_orders`
--

DROP TABLE IF EXISTS `part_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_orders` (
  `part_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `client_part_order_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`part_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_orders`
--

LOCK TABLES `part_orders` WRITE;
/*!40000 ALTER TABLE `part_orders` DISABLE KEYS */;
INSERT INTO `part_orders` VALUES (1,'2015-08-01','PENDING',NULL);
/*!40000 ALTER TABLE `part_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parts` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_article` varchar(45) NOT NULL,
  `part_name` varchar(45) NOT NULL,
  PRIMARY KEY (`part_id`),
  UNIQUE KEY `part_id_UNIQUE` (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'TRW-76568','Тормозные колодки передние'),(2,'TRW-67904','Тормозные колодки задние');
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_has_dates_salarys`
--

DROP TABLE IF EXISTS `person_has_dates_salarys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_has_dates_salarys` (
  `person_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `salary` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_has_dates_salarys`
--

LOCK TABLES `person_has_dates_salarys` WRITE;
/*!40000 ALTER TABLE `person_has_dates_salarys` DISABLE KEYS */;
INSERT INTO `person_has_dates_salarys` VALUES (1,'2015-01-22',120);
/*!40000 ALTER TABLE `person_has_dates_salarys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persons` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1),(4);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `article` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_id_UNIQUE` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'ТС-3','Замена передних тормозных колодок');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregator_has_logins`
--

DROP TABLE IF EXISTS `site_aggregator_has_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregator_has_logins` (
  `site_aggregator_id` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  PRIMARY KEY (`site_aggregator_id`,`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_has_logins`
--

LOCK TABLES `site_aggregator_has_logins` WRITE;
/*!40000 ALTER TABLE `site_aggregator_has_logins` DISABLE KEYS */;
INSERT INTO `site_aggregator_has_logins` VALUES (1,'boris'),(1,'pit');
/*!40000 ALTER TABLE `site_aggregator_has_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregator_has_orders_stations`
--

DROP TABLE IF EXISTS `site_aggregator_has_orders_stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregator_has_orders_stations` (
  `site_aggregator_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `station_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_has_orders_stations`
--

LOCK TABLES `site_aggregator_has_orders_stations` WRITE;
/*!40000 ALTER TABLE `site_aggregator_has_orders_stations` DISABLE KEYS */;
INSERT INTO `site_aggregator_has_orders_stations` VALUES (1,1,1),(1,12,1),(1,13,1),(1,14,1),(1,15,1),(1,16,1),(1,18,1),(1,19,1),(1,20,1),(1,21,1),(1,22,1),(1,23,1),(1,24,1),(1,25,1),(1,26,1),(1,27,1),(1,28,1),(1,29,1),(1,30,1),(1,31,1),(1,32,1),(1,33,1),(1,34,1),(1,35,2);
/*!40000 ALTER TABLE `site_aggregator_has_orders_stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregator_has_persons_mechanic_profiles`
--

DROP TABLE IF EXISTS `site_aggregator_has_persons_mechanic_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregator_has_persons_mechanic_profiles` (
  `site_aggregator_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `mechanic_profile_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_has_persons_mechanic_profiles`
--

LOCK TABLES `site_aggregator_has_persons_mechanic_profiles` WRITE;
/*!40000 ALTER TABLE `site_aggregator_has_persons_mechanic_profiles` DISABLE KEYS */;
INSERT INTO `site_aggregator_has_persons_mechanic_profiles` VALUES (1,1,1);
/*!40000 ALTER TABLE `site_aggregator_has_persons_mechanic_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregator_has_stations_station_profiles`
--

DROP TABLE IF EXISTS `site_aggregator_has_stations_station_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregator_has_stations_station_profiles` (
  `site_aggregator_id` int(11) NOT NULL,
  `station_id` int(11) NOT NULL,
  `station_profile_id` int(11) NOT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_has_stations_station_profiles`
--

LOCK TABLES `site_aggregator_has_stations_station_profiles` WRITE;
/*!40000 ALTER TABLE `site_aggregator_has_stations_station_profiles` DISABLE KEYS */;
INSERT INTO `site_aggregator_has_stations_station_profiles` VALUES (1,1,1),(1,2,4);
/*!40000 ALTER TABLE `site_aggregator_has_stations_station_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregator_site_users`
--

DROP TABLE IF EXISTS `site_aggregator_site_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregator_site_users` (
  `site_aggregator_id` int(11) NOT NULL,
  `site_user_id` int(11) NOT NULL,
  PRIMARY KEY (`site_aggregator_id`,`site_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_site_users`
--

LOCK TABLES `site_aggregator_site_users` WRITE;
/*!40000 ALTER TABLE `site_aggregator_site_users` DISABLE KEYS */;
INSERT INTO `site_aggregator_site_users` VALUES (1,2),(1,3);
/*!40000 ALTER TABLE `site_aggregator_site_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_aggregators`
--

DROP TABLE IF EXISTS `site_aggregators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_aggregators` (
  `site_aggregator_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`site_aggregator_id`),
  UNIQUE KEY `site_aggregator_id_UNIQUE` (`site_aggregator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregators`
--

LOCK TABLES `site_aggregators` WRITE;
/*!40000 ALTER TABLE `site_aggregators` DISABLE KEYS */;
INSERT INTO `site_aggregators` VALUES (1);
/*!40000 ALTER TABLE `site_aggregators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_user_has_orders_stations`
--

DROP TABLE IF EXISTS `site_user_has_orders_stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_user_has_orders_stations` (
  `site_user_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `station_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_user_has_orders_stations`
--

LOCK TABLES `site_user_has_orders_stations` WRITE;
/*!40000 ALTER TABLE `site_user_has_orders_stations` DISABLE KEYS */;
INSERT INTO `site_user_has_orders_stations` VALUES (2,1,1);
/*!40000 ALTER TABLE `site_user_has_orders_stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_users`
--

DROP TABLE IF EXISTS `site_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site_users` (
  `site_user_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`site_user_id`),
  UNIQUE KEY `site_user_id_UNIQUE` (`site_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_users`
--

LOCK TABLES `site_users` WRITE;
/*!40000 ALTER TABLE `site_users` DISABLE KEYS */;
INSERT INTO `site_users` VALUES (2),(3);
/*!40000 ALTER TABLE `site_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_has_affilates_affilate_profiles`
--

DROP TABLE IF EXISTS `station_has_affilates_affilate_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_has_affilates_affilate_profiles` (
  `station_id` int(11) NOT NULL,
  `affilate_id` int(11) NOT NULL,
  `affilate_profile_id` int(11) NOT NULL,
  PRIMARY KEY (`station_id`,`affilate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_has_affilates_affilate_profiles`
--

LOCK TABLES `station_has_affilates_affilate_profiles` WRITE;
/*!40000 ALTER TABLE `station_has_affilates_affilate_profiles` DISABLE KEYS */;
INSERT INTO `station_has_affilates_affilate_profiles` VALUES (1,1,1);
/*!40000 ALTER TABLE `station_has_affilates_affilate_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_has_logins`
--

DROP TABLE IF EXISTS `station_has_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_has_logins` (
  `station_id` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  PRIMARY KEY (`login`,`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_has_logins`
--

LOCK TABLES `station_has_logins` WRITE;
/*!40000 ALTER TABLE `station_has_logins` DISABLE KEYS */;
INSERT INTO `station_has_logins` VALUES (2,'ivanych'),(1,'petrovich');
/*!40000 ALTER TABLE `station_has_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_has_orders_affilates`
--

DROP TABLE IF EXISTS `station_has_orders_affilates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_has_orders_affilates` (
  `station_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `affilate_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`affilate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_has_orders_affilates`
--

LOCK TABLES `station_has_orders_affilates` WRITE;
/*!40000 ALTER TABLE `station_has_orders_affilates` DISABLE KEYS */;
INSERT INTO `station_has_orders_affilates` VALUES (1,1,1),(1,20,1),(1,21,1),(1,22,1),(1,23,1),(1,24,1),(1,25,1),(1,26,1),(1,27,1),(1,28,1),(1,29,1),(1,30,1),(1,31,1),(1,32,1),(1,33,1),(1,34,1),(2,35,1);
/*!40000 ALTER TABLE `station_has_orders_affilates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_persons`
--

DROP TABLE IF EXISTS `station_persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_persons` (
  `station_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_persons`
--

LOCK TABLES `station_persons` WRITE;
/*!40000 ALTER TABLE `station_persons` DISABLE KEYS */;
INSERT INTO `station_persons` VALUES (1,1),(2,4);
/*!40000 ALTER TABLE `station_persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_profile_has_comments`
--

DROP TABLE IF EXISTS `station_profile_has_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_profile_has_comments` (
  `station_profile_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_profile_has_comments`
--

LOCK TABLES `station_profile_has_comments` WRITE;
/*!40000 ALTER TABLE `station_profile_has_comments` DISABLE KEYS */;
INSERT INTO `station_profile_has_comments` VALUES (1,1);
/*!40000 ALTER TABLE `station_profile_has_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_profile_has_marks`
--

DROP TABLE IF EXISTS `station_profile_has_marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_profile_has_marks` (
  `station_profile_id` int(11) NOT NULL,
  `mark_id` int(11) NOT NULL,
  PRIMARY KEY (`mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_profile_has_marks`
--

LOCK TABLES `station_profile_has_marks` WRITE;
/*!40000 ALTER TABLE `station_profile_has_marks` DISABLE KEYS */;
INSERT INTO `station_profile_has_marks` VALUES (1,1);
/*!40000 ALTER TABLE `station_profile_has_marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_profiles`
--

DROP TABLE IF EXISTS `station_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station_profiles` (
  `station_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`station_profile_id`),
  UNIQUE KEY `station_profile_id_UNIQUE` (`station_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_profiles`
--

LOCK TABLES `station_profiles` WRITE;
/*!40000 ALTER TABLE `station_profiles` DISABLE KEYS */;
INSERT INTO `station_profiles` VALUES (1),(2),(3),(4);
/*!40000 ALTER TABLE `station_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stations` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(45) NOT NULL,
  `person_station_id` varchar(45) NOT NULL,
  PRIMARY KEY (`station_id`),
  UNIQUE KEY `station_id_UNIQUE` (`station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES (1,'Северная автосервисная станция','nord'),(2,'Южная автосервисная станция','south'),(3,'Южная автосервисная станция','south'),(4,'Южная автосервисная станция','south');
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-14 21:53:42