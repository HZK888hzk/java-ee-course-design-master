-- MySQL dump 10.11
--
-- Host: localhost    Database: excellent
-- ------------------------------------------------------
-- Server version	5.0.88-community-nt

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
-- Table structure for table `a`
--

DROP TABLE IF EXISTS `a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `a` (
  `id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `url` varchar(255) collate utf8_unicode_ci default NULL,
  `state` varchar(255) collate utf8_unicode_ci default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a`
--

LOCK TABLES `a` WRITE;
/*!40000 ALTER TABLE `a` DISABLE KEYS */;
/*!40000 ALTER TABLE `a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `classId` int(11) NOT NULL auto_increment,
  `classNum` int(255) NOT NULL,
  `count` int(20) default NULL,
  PRIMARY KEY  (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,2121,50),(2,2122,11),(3,2123,20),(4,2124,30),(5,2125,25),(6,2126,5),(7,2127,15),(8,2128,19);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `comId` int(11) NOT NULL auto_increment,
  `comName` varchar(255) NOT NULL,
  `comMeg` varchar(255) NOT NULL,
  `comAddress` varchar(255) NOT NULL,
  `comHr` varchar(255) NOT NULL,
  `comHrTel` int(11) NOT NULL,
  `comJobId` int(11) NOT NULL,
  `comCount` int(255) default NULL,
  PRIMARY KEY  (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'字节跳动','字节跳动','北京','张三',123456789,1,30),(2,'百度','百度','上海','李四',1234568525,2,11),(3,'网易','网易','广州','张文',2563,2,10),(4,'360','360','杭州','张鹏',132456789,1,12),(5,'华为','华为','太原','王五',123456789,2,20),(6,'优胜','优胜','西安','会话',1111111,1,55),(7,'尚硅谷','尚硅谷','成都','张武',222222222,2,53),(8,'阿里','阿里','南京','啊哈哈',11111,1,60);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contant_info`
--

DROP TABLE IF EXISTS `contant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contant_info` (
  `id` int(20) NOT NULL auto_increment,
  `type` varchar(500) default NULL,
  `title` varchar(500) default NULL,
  `constant` varchar(500) default NULL,
  `time` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contant_info`
--

LOCK TABLES `contant_info` WRITE;
/*!40000 ALTER TABLE `contant_info` DISABLE KEYS */;
INSERT INTO `contant_info` VALUES (8,'就业','就业信息','3月20日在2号楼有英语专场的招聘会','2023-03-06 16:00:00'),(10,'毕业论文','毕业论文','全体学生：今天开始毕业论文查重','2023-05-15 16:00:00'),(11,'就业','就业信息','5月30日有计算机专场招聘会','2023-05-23 16:00:00'),(13,'就业','就业信息','5月25日有核桃编程的专场招聘会','2023-05-16 16:00:00'),(14,'毕业论文','毕业答辩','5月30日开始组织答辩','2023-05-20 16:00:00');
/*!40000 ALTER TABLE `contant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direction`
--

DROP TABLE IF EXISTS `direction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direction` (
  `dirID` int(11) NOT NULL auto_increment,
  `dirName` varchar(255) NOT NULL,
  PRIMARY KEY  (`dirID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direction`
--

LOCK TABLES `direction` WRITE;
/*!40000 ALTER TABLE `direction` DISABLE KEYS */;
INSERT INTO `direction` VALUES (1,'计算机专业'),(2,'经济管理专业'),(3,'化学专业'),(4,'体育专业'),(5,'艺术专业'),(6,'化学专业'),(7,'英语专业'),(8,'美术专业');
/*!40000 ALTER TABLE `direction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echarts`
--

DROP TABLE IF EXISTS `echarts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echarts` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) collate utf8_unicode_ci default NULL,
  `count` int(11) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echarts`
--

LOCK TABLES `echarts` WRITE;
/*!40000 ALTER TABLE `echarts` DISABLE KEYS */;
/*!40000 ALTER TABLE `echarts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduate`
--

DROP TABLE IF EXISTS `graduate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `graduate` (
  `graID` int(11) NOT NULL auto_increment,
  `graSex` varchar(255) default NULL,
  `graTel` varchar(255) default NULL,
  `graClassId` int(11) default NULL,
  `graTime` datetime default NULL,
  `graComId` int(11) default NULL,
  `graDirId` int(11) default NULL,
  `graSalary` int(255) default NULL,
  `comAdd` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY  (`graID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduate`
--

LOCK TABLES `graduate` WRITE;
/*!40000 ALTER TABLE `graduate` DISABLE KEYS */;
INSERT INTO `graduate` VALUES (1,'女','13320624941',1,'2020-10-11 00:00:00',1,2,5000,'北京','1'),(2,'女','13320624942',7,'2020-09-09 00:00:00',1,4,1200,'北京','1'),(3,'女','13320624943',2,'2020-10-11 00:00:00',3,2,2000,'上海','1'),(4,'女','13320624944',6,'2020-10-21 06:00:00',1,2,5000,'北京','1'),(5,'女','13320624946',3,'1997-10-20 09:40:00',2,2,1500,'上海','1'),(6,'女','13320624947',2,'2019-12-01 00:00:00',1,3,2000,'北京','1'),(7,'女','13320624948',2,'1988-12-20 04:06:00',2,4,1200,'上海','1'),(8,'男','13320624949',1,'2020-10-28 04:30:00',1,1,2000,'北京','1'),(9,'女','13620624941',6,'2021-01-21 05:31:00',4,5,4000,'杭州','1'),(10,'男','13620624941',3,'2022-08-11 16:45:00',3,8,1000,'北京','1'),(11,'男','13620624942',2,'2020-05-01 00:00:00',7,7,5000,'成都','1'),(12,'男','13620624943',5,'2000-10-20 00:00:00',8,7,5000,'南京','1'),(13,'男','13620624944',2,'2000-10-20 00:00:00',7,7,1500,'成都','1'),(14,'男','13620624945',8,'2022-12-11 00:00:00',5,6,2000,'太原','1'),(15,'男','13620624946',1,'2022-11-11 00:00:00',7,6,1000,'成都','1'),(16,'女','13620624947',2,'2023-05-15 17:02:39',1,1,3000,'北京','1'),(17,'女','13620624948',5,'2023-05-10 17:03:11',2,4,5000,'上海','1'),(18,'女','13620624949',2,'2023-02-16 00:00:00',6,2,2000,'西安','1'),(19,'男','13720624941',4,'2023-05-16 09:56:39',6,6,1000,'西安','1'),(20,'女','13720624941',3,'2023-05-19 09:07:10',5,7,2000,'成都','1'),(29,'男','13720624942',1,'2021-12-01 00:00:00',1,1,1500,'北京','1'),(30,'男','13720624943',3,'2021-12-01 12:00:00',5,1,1000,'北京','1'),(31,'男','13720624944',2,'2023-12-01 12:00:00',7,1,1200,'北京','1'),(32,'女','13720624945',8,'2023-05-20 10:13:41',8,4,2000,'南京','1'),(33,'男','13720624946',7,'2021-12-01 00:00:00',1,1,1500,'北京','1'),(34,'女','13720624947',8,'2021-12-01 00:00:00',1,3,1000,'北京','1'),(35,'男','13720624948',1,'2121-12-12 00:00:00',1,3,2000,'南京','0'),(38,'男','13720624949',1,'2021-12-01 00:00:00',1,3,1600,'北京','0'),(39,'男','13820624941',1,'2021-12-02 00:00:00',1,3,2000,'北京','0'),(40,'男','13820624942',1,'2021-12-02 00:00:00',1,3,1600,'北京','0'),(41,'男','13820624943',1,'2021-12-01 00:00:00',1,1,1500,'北京','0'),(42,'男','13820624944',1,'2023-01-02 00:00:00',1,1,1360,'北京','0'),(43,'男','13820624945',1,'2022-03-20 00:00:00',1,1,2000,'北京','0'),(44,'男','13820624946',1,'2022-01-03 00:00:00',1,1,1000,'北京','0'),(45,'男','13820624947',1,'2022-02-20 00:00:00',1,1,1000,'北京','0'),(46,'男','13820624948',1,'2021-02-03 00:00:00',1,1,2000,'北京','0'),(47,'男','13920624941',1,'2021-02-03 00:00:00',1,1,2500,'北京','0'),(48,'女','13920624942',1,'2023-02-03 00:00:00',1,1,2500,'北京','1'),(49,'男','13920624943',1,'2021-12-01 00:00:00',1,1,3000,'北京','1'),(50,'女','13920624944',1,'2021-11-01 00:00:00',1,1,2000,'北京','1'),(51,'男','13920624945',1,'2021-12-01 00:00:00',1,1,2000,'北京','1'),(52,'男','13920624946',1,'2021-11-22 00:00:00',1,1,4343,'北京','0'),(53,'男','13920624947',1,'2022-02-02 00:00:00',1,1,5000,'北京','1'),(54,'男','13920624948',1,'2021-12-01 00:00:00',3,1,11111,'杭州','1'),(55,'男','13920624949',1,'2021-12-01 00:00:00',1,1,1111,'太原','1');
/*!40000 ALTER TABLE `graduate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL COMMENT '外键--user表',
  `groupid` int(11) NOT NULL COMMENT '队伍编号',
  `usertype` int(11) NOT NULL COMMENT '用户类型1-组长 0-组员',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,1,1,1),(2,2,1,0),(3,3,1,0),(4,2,2,1);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `jobId` int(11) NOT NULL auto_increment,
  `jobName` varchar(255) NOT NULL,
  `jobDe` varchar(255) NOT NULL,
  PRIMARY KEY  (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'架构师','1122'),(2,'大数据','565'),(3,'java开发','852');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(255) NOT NULL,
  `useraccount` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `types` int(11) NOT NULL,
  `graID` int(11) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'王五','2222','222',1,1),(2,'张翔宇','111','111',0,2),(3,'李四','1','1',1,3),(4,'王五','2','2',1,4),(5,'赵六','3','3',1,5),(6,'菲菲','5','5',1,6),(7,'小张','9','9',1,7),(8,'张小小','7890','7890',0,8),(9,'李艾','7895','123',1,9),(10,'张六','csd','111111',1,10),(11,'张七','dsifji','11111',1,11),(12,'张八','2','21651',1,12),(13,'张九','23','21651',1,13),(14,'王四','234','11111',1,14),(15,'王六','2345','14141',1,15),(16,'王二五','1111','1111',0,16),(17,'李二四','1212','1212',1,17),(18,'王二五','1313','1313',1,18),(19,'赵二六','1414','1414',1,19),(20,'大宁','123123','123123',1,20),(29,'郭嘉康','111','1',1,29),(30,'赵三七','11','1',1,30),(31,'赵四九','111111111','1',1,31),(32,'李博','1212','1212',1,32),(33,'李三四','111111111','1',1,33),(34,'李五','111111111','1',1,34),(35,'张八','1','1',1,35),(38,'张九','12','12',1,38),(39,'张十','111111111','1',1,39),(40,'郭一','111','1',1,40),(41,'郭二','11111','1',1,41),(42,'郭三','132','1',1,42),(43,'郭四','22','1',1,43),(44,'郭五','23445','1',1,44),(45,'郭六','23234','1',1,45),(46,'郭七','12','1',1,46),(47,'郭八','1','1',1,47),(48,'郭九','1','1',1,48),(49,'贠一','111','1',1,49),(50,'贠二','111111','1',1,50),(51,'贠三','11111111','111',1,51),(52,'贠四','121','111',1,52),(53,'贠五','112','111',1,53),(54,'贠六','111111','111',1,54),(55,'贠七','11111','1',1,55);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 10:25:27
