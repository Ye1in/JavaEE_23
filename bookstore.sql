/*
Navicat MySQL Data Transfer

Source Server         : bookmanager
Source Server Version : 50721
Source Host           : whitenight.xin:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-05 21:46:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `picture` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `catalogid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `FK2E3AE992D3BC48` (`catalogid`),
  CONSTRAINT `FK2E3AE992D3BC48` FOREIGN KEY (`catalogid`) REFERENCES `catalog` (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'java', '21', 'java.jpg', '1');
INSERT INTO `book` VALUES ('2', 'J2EE应用实践教程', '35', 'j2ee.jpg', '1');
INSERT INTO `book` VALUES ('3', 'MySQL应用教程', '48', 'mySql.jpg', '1');
INSERT INTO `book` VALUES ('4', 'Java Web实用教程', '22', 'javaWeb.jpg', '1');

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalogid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogname` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '计算机');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderitemid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderitemid`),
  KEY `FKE8B2AB61BEDB3733` (`orderid`),
  KEY `FKE8B2AB61A101DD52` (`bookid`),
  CONSTRAINT `FKE8B2AB61A101DD52` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`),
  CONSTRAINT `FKE8B2AB61BEDB3733` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('10', '1', '17', '2');
INSERT INTO `orderitem` VALUES ('11', '2', '18', '4');
INSERT INTO `orderitem` VALUES ('12', '1', '18', '2');
INSERT INTO `orderitem` VALUES ('13', '1', '19', '3');
INSERT INTO `orderitem` VALUES ('14', '2', '20', '2');
INSERT INTO `orderitem` VALUES ('15', '1', '20', '1');
INSERT INTO `orderitem` VALUES ('16', '2', '21', '1');
INSERT INTO `orderitem` VALUES ('17', '1', '21', '2');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `orderdate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FKC3DF62E5C1AA8E96` (`userid`),
  CONSTRAINT `FKC3DF62E5C1AA8E96` FOREIGN KEY (`userid`) REFERENCES `usertable` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('17', '1', '2018-06-18 01:19:38');
INSERT INTO `orders` VALUES ('18', '1', '2018-06-18 01:26:02');
INSERT INTO `orders` VALUES ('19', '1', '2018-06-18 01:26:56');
INSERT INTO `orders` VALUES ('20', '1', '2018-06-19 00:42:46');
INSERT INTO `orders` VALUES ('21', '5', '2018-06-19 16:30:58');

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `sex` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('1', 'admin', 'admin', ' ', '1');
INSERT INTO `usertable` VALUES ('2', '123', '123', '��', '21');
INSERT INTO `usertable` VALUES ('3', '2015123', '123456', 'Ů', '21');
INSERT INTO `usertable` VALUES ('4', 'admin', 'admin', 'Ů', '1');
INSERT INTO `usertable` VALUES ('5', 'Luanluanx', '123456', '��', '16');
