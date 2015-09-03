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
INSERT INTO `affilate_has_part_orders_persons` VALUES (2,1,1),(2,2,1),(2,3,1),(2,4,1),(2,5,1),(2,6,8),(2,7,1);
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
INSERT INTO `affilate_has_parts_counts` VALUES (2,1,437),(2,2,600),(2,3,20);
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
INSERT INTO `affilate_has_persons` VALUES (2,1),(3,4),(2,8);
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
INSERT INTO `affilate_has_services_costs` VALUES (2,1,10),(2,2,11);
/*!40000 ALTER TABLE `affilate_has_services_costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affilate_orders_persons`
--

DROP TABLE IF EXISTS `affilate_orders_persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affilate_orders_persons` (
  `affilate_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`person_id`),
  KEY `order_id_idx` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_orders_persons`
--

LOCK TABLES `affilate_orders_persons` WRITE;
/*!40000 ALTER TABLE `affilate_orders_persons` DISABLE KEYS */;
INSERT INTO `affilate_orders_persons` VALUES (3,39,4),(3,40,4),(3,41,4),(2,43,1),(2,45,1),(2,46,1),(2,50,8);
/*!40000 ALTER TABLE `affilate_orders_persons` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilate_profiles`
--

LOCK TABLES `affilate_profiles` WRITE;
/*!40000 ALTER TABLE `affilate_profiles` DISABLE KEYS */;
INSERT INTO `affilate_profiles` VALUES (2),(3),(4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affilates`
--

LOCK TABLES `affilates` WRITE;
/*!40000 ALTER TABLE `affilates` DISABLE KEYS */;
INSERT INTO `affilates` VALUES (1,'NULL'),(2,'altufievo'),(3,'anino'),(4,'snowden');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_notifications`
--

LOCK TABLES `client_notifications` WRITE;
/*!40000 ALTER TABLE `client_notifications` DISABLE KEYS */;
INSERT INTO `client_notifications` VALUES (1,'Выполнение заказа переносится на неопределённый срок. Ожидаем запчастей.'),(2,'уведомление'),(3,'notification'),(4,'уккуцаца'),(5,'Отправлен запрос на завод в Штутгард.');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Удобная станция. Советую.','2015-08-02',2,''),(2,'Грамотный специалист. Рекомендую.','2015-08-02',3,''),(3,'}{орошая Станция!','2015-08-19',2,''),(4,'}{орошая Станция!','2015-08-19',2,''),(5,'}{орошая Станция!','2015-08-19',2,''),(6,'Да','2015-08-19',2,''),(7,'Иваныыыч!','2015-08-19',2,''),(8,'Бесит манера общаться','2015-08-24',2,''),(9,'Сволочи, одним словом','2015-08-24',2,''),(10,'То director','2015-08-24',2,''),(11,'dirrrrr','2015-08-24',2,'\0'),(12,'Скрытый омментарий','2015-08-28',2,'\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logginers`
--

LOCK TABLES `logginers` WRITE;
/*!40000 ALTER TABLE `logginers` DISABLE KEYS */;
INSERT INTO `logginers` VALUES (0,'NULL','NULL',';lsdfmsl;admflsamdclsakmfwasc klmwefmwlkm','MECHANIC'),(1,'Петрович','petrovich','petrovich','MECHANIC'),(2,'Петя','pit','pit','USER'),(3,'Боря','boris','boris','USER'),(4,'Иваныч','ivanych','ivanych','MECHANIC'),(5,'Зина','zina','zina','ACCOUNTANT'),(6,'Виктор Петрович','viktor','viktor','CEO'),(7,'Анатоль','tolik','tolik','USER'),(8,'Ганс','gans','gans','MECHANIC');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,4,'2015-08-02',2),(2,3,'2015-08-17',2),(3,5,'2015-08-24',2),(4,1,'2015-08-28',2);
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
INSERT INTO `mechanic_profile_has_comments` VALUES (1,2),(2,7),(2,8);
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
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`mechanic_profile_id`),
  UNIQUE KEY `mechanic_profile_id_UNIQUE` (`mechanic_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic_profiles`
--

LOCK TABLES `mechanic_profiles` WRITE;
/*!40000 ALTER TABLE `mechanic_profiles` DISABLE KEYS */;
INSERT INTO `mechanic_profiles` VALUES (1,'Грамотнй специалист с большим опытом работы'),(2,'Перспективный стажёр'),(3,'Механик прямо из Германии. Плохо говорит по-русски');
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
  PRIMARY KEY (`order_id`,`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_parts_counts`
--

LOCK TABLES `order_has_parts_counts` WRITE;
/*!40000 ALTER TABLE `order_has_parts_counts` DISABLE KEYS */;
INSERT INTO `order_has_parts_counts` VALUES (43,1,208),(43,2,2),(45,1,78),(45,2,245),(46,1,2),(50,3,2);
/*!40000 ALTER TABLE `order_has_parts_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `order_parts_counts`
--

DROP TABLE IF EXISTS `order_parts_counts`;
/*!50001 DROP VIEW IF EXISTS `order_parts_counts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `order_parts_counts` AS SELECT 
 1 AS `order_id`,
 1 AS `count`,
 1 AS `part_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `order_services_costs_counts`
--

DROP TABLE IF EXISTS `order_services_costs_counts`;
/*!50001 DROP VIEW IF EXISTS `order_services_costs_counts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `order_services_costs_counts` AS SELECT 
 1 AS `order_id`,
 1 AS `count`,
 1 AS `cost`,
 1 AS `name`,
 1 AS `sum`*/;
SET character_set_client = @saved_cs_client;

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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'NEW','2015-08-18',NULL,'Сильная вибрация при скорости больше 80 км//ч',NULL,NULL,NULL),(38,'NEW','2015-08-18',NULL,'Всё время открывается капот. Невозможно ехать.',NULL,NULL,NULL),(39,'ACCEPTED','2015-08-18','2015-08-25','Муравьи в салоне',3,NULL,NULL),(40,'ACCEPTED','2015-08-22','2015-08-25','Бора плохо тянет',NULL,NULL,NULL),(41,'ACCEPTED','2015-08-19',NULL,'Сломалась труба',NULL,NULL,NULL),(42,'NEW','2015-08-19',NULL,'поломка тачки',NULL,NULL,NULL),(43,'READY','2015-08-19','2015-08-25','Коробка предач заедает. колёса отваливаются. крыша сетает. стёклы дребезжат. вонает в салоне. фары отвалились. поцарапанная и не ездит.',2,NULL,NULL),(44,'NEW','2015-08-24',NULL,'Проблема с колесом',NULL,NULL,'(29) 884 21 43'),(45,'ACCEPTED','2015-08-24','2015-08-25','Проблема',4,NULL,'435435435'),(46,'READY','2015-08-24',NULL,'северная проблема',NULL,NULL,NULL),(47,'NEW','2015-08-28',NULL,'Автомобиль не заводится. Щелкает что-то под капотом.',NULL,NULL,NULL),(48,'NEW','2015-08-28',NULL,'Дворники не работают. Стоп сигнал не горит.',NULL,NULL,NULL),(49,'NEW','2015-08-28',NULL,'Отвалился бампер после удара о столб',NULL,NULL,NULL),(50,'ACCEPTED','2015-08-28','2015-09-11','Сигнализация заблокировала автомобиль. Невозможно попасть внурь.',5,NULL,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_services_costs`
--

DROP TABLE IF EXISTS `orders_services_costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_services_costs` (
  `order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `cost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_services_costs`
--

LOCK TABLES `orders_services_costs` WRITE;
/*!40000 ALTER TABLE `orders_services_costs` DISABLE KEYS */;
INSERT INTO `orders_services_costs` VALUES (43,1,10),(43,2,11),(45,1,10),(45,2,11),(50,1,10),(46,2,11);
/*!40000 ALTER TABLE `orders_services_costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_services_counts`
--

DROP TABLE IF EXISTS `orders_services_counts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_services_counts` (
  `order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_services_counts`
--

LOCK TABLES `orders_services_counts` WRITE;
/*!40000 ALTER TABLE `orders_services_counts` DISABLE KEYS */;
INSERT INTO `orders_services_counts` VALUES (43,1,2),(43,2,1),(45,1,1),(45,2,1),(50,1,1),(46,2,1);
/*!40000 ALTER TABLE `orders_services_counts` ENABLE KEYS */;
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
  PRIMARY KEY (`part_order_id`,`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_order_has_parts_counts`
--

LOCK TABLES `part_order_has_parts_counts` WRITE;
/*!40000 ALTER TABLE `part_order_has_parts_counts` DISABLE KEYS */;
INSERT INTO `part_order_has_parts_counts` VALUES (1,1,2),(2,1,12),(3,1,200),(3,2,300),(4,1,22),(5,1,1),(6,3,234),(7,3,7);
/*!40000 ALTER TABLE `part_order_has_parts_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `part_order_parts_counts`
--

DROP TABLE IF EXISTS `part_order_parts_counts`;
/*!50001 DROP VIEW IF EXISTS `part_order_parts_counts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `part_order_parts_counts` AS SELECT 
 1 AS `part_order_id`,
 1 AS `count`,
 1 AS `part_name`*/;
SET character_set_client = @saved_cs_client;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_orders`
--

LOCK TABLES `part_orders` WRITE;
/*!40000 ALTER TABLE `part_orders` DISABLE KEYS */;
INSERT INTO `part_orders` VALUES (1,'2015-08-01','READY',NULL),(2,'2015-08-24','READY',NULL),(3,'2015-08-25','READY',NULL),(4,'2015-08-26','READY',NULL),(5,'2015-08-26','READY',NULL),(6,'2015-09-01','PENDING',NULL),(7,'2015-09-03','READY',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'TRW-76568','Тормозные колодки передние'),(2,'TRW-67904','Тормозные колодки задние'),(3,'Febi-3456','Тяга стабилизатора');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1),(4),(5),(6),(8);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'ТС-3','Замена передних тормозных колодок'),(2,'TC-5','Замена задних тормозных колодок');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
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
  PRIMARY KEY (`order_id`,`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_aggregator_has_orders_stations`
--

LOCK TABLES `site_aggregator_has_orders_stations` WRITE;
/*!40000 ALTER TABLE `site_aggregator_has_orders_stations` DISABLE KEYS */;
INSERT INTO `site_aggregator_has_orders_stations` VALUES (1,1,3),(1,38,4),(1,39,2),(1,40,2),(1,41,2),(1,42,4),(1,43,1),(1,44,2),(1,45,1),(1,46,1),(1,47,1),(1,48,2),(1,49,1),(1,50,1);
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
INSERT INTO `site_aggregator_has_persons_mechanic_profiles` VALUES (1,1,1),(1,4,2),(1,8,3);
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
INSERT INTO `site_aggregator_has_stations_station_profiles` VALUES (1,1,1),(1,2,2),(1,3,3),(1,4,4);
/*!40000 ALTER TABLE `site_aggregator_has_stations_station_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `site_aggregator_services_ids_names`
--

DROP TABLE IF EXISTS `site_aggregator_services_ids_names`;
/*!50001 DROP VIEW IF EXISTS `site_aggregator_services_ids_names`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `site_aggregator_services_ids_names` AS SELECT 
 1 AS `site_aggregator_id`,
 1 AS `station_id`,
 1 AS `station_name`*/;
SET character_set_client = @saved_cs_client;

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
INSERT INTO `site_user_has_orders_stations` VALUES (2,1,3),(2,38,4),(2,39,2),(3,40,2),(2,41,2),(2,42,4),(2,43,1),(2,46,1),(7,47,1),(7,48,2),(3,49,1),(3,50,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_users`
--

LOCK TABLES `site_users` WRITE;
/*!40000 ALTER TABLE `site_users` DISABLE KEYS */;
INSERT INTO `site_users` VALUES (2),(3),(7);
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
INSERT INTO `station_has_affilates_affilate_profiles` VALUES (1,2,2),(1,4,4),(2,3,3);
/*!40000 ALTER TABLE `station_has_affilates_affilate_profiles` ENABLE KEYS */;
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
  PRIMARY KEY (`order_id`,`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_has_orders_affilates`
--

LOCK TABLES `station_has_orders_affilates` WRITE;
/*!40000 ALTER TABLE `station_has_orders_affilates` DISABLE KEYS */;
INSERT INTO `station_has_orders_affilates` VALUES (3,1,1),(4,38,1),(2,39,3),(2,40,3),(2,41,3),(4,42,1),(1,43,2),(2,44,1),(1,45,2),(1,46,2),(1,47,1),(2,48,1),(1,49,1),(1,50,2);
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
INSERT INTO `station_persons` VALUES (1,1),(2,4),(1,5),(1,6),(1,8);
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
INSERT INTO `station_profile_has_comments` VALUES (1,1),(1,3),(1,4),(1,5),(2,6),(3,9),(4,10),(4,11),(1,12);
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
INSERT INTO `station_profile_has_marks` VALUES (1,1),(4,2),(3,3),(1,4);
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
  `info` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`station_profile_id`),
  UNIQUE KEY `station_profile_id_UNIQUE` (`station_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_profiles`
--

LOCK TABLES `station_profiles` WRITE;
/*!40000 ALTER TABLE `station_profiles` DISABLE KEYS */;
INSERT INTO `station_profiles` VALUES (1,'Станция расположена в живописном лесу около нарочанских озёр'),(2,'Доблесная история станции создаёт образ надёжного партнера'),(3,'Посредственный сервис, зато цены не кусаются'),(4,'Кофе предлагают замечательный, но автомобиль им лучше не оставлять');
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
  PRIMARY KEY (`station_id`),
  UNIQUE KEY `station_id_UNIQUE` (`station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES (1,'Северная автосервисная станция'),(2,'Южная автосервисная станция'),(3,'Западная автосервисная станция'),(4,'Восточная автосервисная станция');
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'servicestation'
--
/*!50003 DROP PROCEDURE IF EXISTS `customer_order_dto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_order_dto`(in orderid int)
BEGIN
	declare stationid, mechanicid, ordersum int;
    
    
    select 
		person_id into mechanicid 
	from 
		affilate_orders_persons
	where 
		order_id = orderid;
    
    
    select 
		sum(sum) into ordersum
	from
		order_services_costs_counts
	where 
		order_id = orderid;
    
    
    select 
		station_id into stationid 
	from 
		site_aggregator_has_orders_stations
	where 
		order_id = orderid;
    
	
    select 
		orders.order_id,
		orders.order_problem_description,
		orders.order_status,
		orders.order_create_date,
		orders.order_compleate_date,
		stations.station_name,
        client_notifications.client_notification,
        logginers.name,
        ordersum
	from
		orders
			left join 
				stations
			on
				stations.station_id = stationid
			left join
				client_notifications
			using (client_notification_id)
            left join
				logginers
			on
				logginers.id = mechanicid
	where 
		orders.order_id = orderid;
					
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_affilate_by_part_order_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_affilate_by_part_order_id`(in partorderid int)
BEGIN
	select * from affilates where affilate_id IN (select affilate_id from affilate_has_part_orders_persons where part_order_id = partorderid);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_mechanic_part_orders_dto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_mechanic_part_orders_dto`(IN mechanicid INT(10))
BEGIN

 SELECT part_orders.part_order_id,
     part_orders.date,
     part_orders.status,
  (part_orders.status = 'PENDING') AS canchange
 FROM part_orders
 WHERE part_orders.part_order_id in
 	(select part_order_id
	from affilate_has_part_orders_persons
	where person_id = mechanicid);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_notifications_by_ceo_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_notifications_by_ceo_id`(IN ceoid INT(10))
BEGIN

 DECLARE stationid INT;

 SELECT station_id
   INTO stationid
   FROM station_persons
  WHERE station_persons.person_id = ceoid;


 SELECT orders.order_id,
        client_notifications.client_notification,
		logginers.name
    FROM orders
 LEFT JOIN client_notifications
     USING (client_notification_id)
	 LEFT JOIN affilate_orders_persons 
	 USING (order_id) 
	 left join logginers
	 on logginers.id = affilate_orders_persons.person_id
	 
	 
	   
   WHERE orders.order_id
     IN (SELECT order_id
        FROM station_has_orders_affilates
       WHERE station_has_orders_affilates.station_id = stationid)
   AND client_notifications.client_notification_id IS NOT NULL;
 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_notifications_by_mechanic_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_notifications_by_mechanic_id`(IN mechanicid int)
BEGIN
  SELECT
   orders.order_id,
    client_notifications.client_notification
 FROM
  orders
   LEFT JOIN
    client_notifications
     USING (client_notification_id)
 WHERE
  orders.order_id IN
   (SELECT
    order_id
   FROM
    affilate_orders_persons
   WHERE
    person_id = mechanicid)
   AND
    client_notification_id IS NOT NULL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_parts_by_part_order_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_parts_by_part_order_id`(
   IN partorderid   INT(10))
BEGIN                                                                     

	select parts.part_name, part_order_has_parts_counts.count
	from part_order_has_parts_counts 
	left join parts using (part_id)
	where part_order_has_parts_counts.part_order_id = partorderid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_site_user_orders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_site_user_orders`(in siteuserid int, in startorder int, in countorder int)
BEGIN

   	select * from orders where order_id IN (select order_id from site_user_has_orders_stations where site_user_id = siteuserid) limit startorder, countorder;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_site_user_orders_count` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_site_user_orders_count`(in siteuserid int)
BEGIN
	select 
		count(*) 
	from 
		site_user_has_orders_stations
	where 
		site_user_id = siteuserid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_station_by_order_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_station_by_order_id`(in orderid int)
BEGIN

	select * from stations where station_id IN (select station_id from site_aggregator_has_orders_stations where order_id = orderid);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `order_parts_counts`
--

/*!50001 DROP VIEW IF EXISTS `order_parts_counts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_parts_counts` AS select `order_has_parts_counts`.`order_id` AS `order_id`,`order_has_parts_counts`.`count` AS `count`,`parts`.`part_name` AS `part_name` from (`order_has_parts_counts` left join `parts` on((`order_has_parts_counts`.`part_id` = `parts`.`part_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `order_services_costs_counts`
--

/*!50001 DROP VIEW IF EXISTS `order_services_costs_counts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_services_costs_counts` AS select `orders_services_counts`.`order_id` AS `order_id`,`orders_services_counts`.`count` AS `count`,`orders_services_costs`.`cost` AS `cost`,`services`.`name` AS `name`,(`orders_services_counts`.`count` * `orders_services_costs`.`cost`) AS `sum` from ((`orders_services_counts` left join `orders_services_costs` on((`orders_services_counts`.`order_id` = `orders_services_costs`.`order_id`))) left join `services` on((`orders_services_counts`.`service_id` = `services`.`service_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `part_order_parts_counts`
--

/*!50001 DROP VIEW IF EXISTS `part_order_parts_counts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `part_order_parts_counts` AS select `part_order_has_parts_counts`.`part_order_id` AS `part_order_id`,`part_order_has_parts_counts`.`count` AS `count`,`parts`.`part_name` AS `part_name` from (`part_order_has_parts_counts` left join `parts` on((`parts`.`part_id` = `part_order_has_parts_counts`.`part_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `site_aggregator_services_ids_names`
--

/*!50001 DROP VIEW IF EXISTS `site_aggregator_services_ids_names`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `site_aggregator_services_ids_names` AS select `site_aggregator_has_stations_station_profiles`.`site_aggregator_id` AS `site_aggregator_id`,`site_aggregator_has_stations_station_profiles`.`station_id` AS `station_id`,`stations`.`station_name` AS `station_name` from (`site_aggregator_has_stations_station_profiles` left join `stations` on((`site_aggregator_has_stations_station_profiles`.`station_id` = `stations`.`station_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-03 10:14:16
