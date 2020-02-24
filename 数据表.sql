/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : dianshang

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2020-02-24 18:47:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `administrator_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `real_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `encrypted_password` varchar(255) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`administrator_id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  KEY `real_name` (`real_name`) USING BTREE,
  KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
