-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: servicestation
-- ------------------------------------------------------
-- Server version	5.5.23

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Temporary table structure for view `order_parts_counts`
--

DROP TABLE IF EXISTS `order_parts_counts`;
/*!50001 DROP VIEW IF EXISTS `order_parts_counts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `order_parts_counts` (
  `order_id` tinyint NOT NULL,
  `count` tinyint NOT NULL,
  `part_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `order_services_costs_counts`
--

DROP TABLE IF EXISTS `order_services_costs_counts`;
/*!50001 DROP VIEW IF EXISTS `order_services_costs_counts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `order_services_costs_counts` (
  `order_id` tinyint NOT NULL,
  `cost` tinyint NOT NULL,
  `count` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `sum` tinyint NOT NULL
) ENGINE=MyISAM */;
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_services_counts_costs`
--

DROP TABLE IF EXISTS `orders_services_counts_costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_services_counts_costs` (
  `order_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `person_has_dates_salarys`
--

DROP TABLE IF EXISTS `person_has_dates_salarys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_has_dates_salarys` (
  `person_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `salary` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`person_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Temporary table structure for view `site_aggregator_services_ids_names`
--

DROP TABLE IF EXISTS `site_aggregator_services_ids_names`;
/*!50001 DROP VIEW IF EXISTS `site_aggregator_services_ids_names`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `site_aggregator_services_ids_names` (
  `site_aggregator_id` tinyint NOT NULL,
  `station_id` tinyint NOT NULL,
  `station_name` tinyint NOT NULL
) ENGINE=MyISAM */;
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
	select 
		affilate_id,
        person_affilate_id
	from 
		affilates 
	where 
		affilate_id IN 
			(select 
				affilate_id 
			from 
				affilate_has_part_orders_persons 
			where 
				part_order_id = partorderid);
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

   	select 
		order_id,
        order_status,
        order_create_date,
        order_compleate_date,
        order_problem_description,
        client_notification_id,
        client_order_id,
        order_contact_data
	from 
		orders 
	where 
		order_id IN 
			(select 
				order_id 
			from 
				site_user_has_orders_stations 
			where 
				site_user_id = siteuserid) 
					limit 
						startorder, 
                        countorder;
    
    
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

	select 
		station_id,
        station_name
	from 
		stations 
	where 
		station_id IN 
			(select 
				station_id 
			from 
				site_aggregator_has_orders_stations 
			where 
				order_id = orderid);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `order_parts_counts`
--

/*!50001 DROP TABLE IF EXISTS `order_parts_counts`*/;
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

/*!50001 DROP TABLE IF EXISTS `order_services_costs_counts`*/;
/*!50001 DROP VIEW IF EXISTS `order_services_costs_counts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_services_costs_counts` AS select `orders_services_counts_costs`.`order_id` AS `order_id`,`orders_services_counts_costs`.`cost` AS `cost`,`orders_services_counts_costs`.`count` AS `count`,`services`.`name` AS `name`,(`orders_services_counts_costs`.`cost` * `orders_services_counts_costs`.`count`) AS `sum` from (`orders_services_counts_costs` left join `services` on((`orders_services_counts_costs`.`service_id` = `services`.`service_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `site_aggregator_services_ids_names`
--

/*!50001 DROP TABLE IF EXISTS `site_aggregator_services_ids_names`*/;
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

-- Dump completed on 2015-09-01  0:33:11
