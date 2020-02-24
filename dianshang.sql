/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : dianshang

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2020-02-24 23:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `receiver_name` varchar(255) NOT NULL,
  `tag` varchar(255) NOT NULL,
  `receiver_mobile` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

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

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `avatar_url` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `mobile_verified` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified` bit(1) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL,
  `real_name` varchar(255) NOT NULL,
  `default_address_id` int(11) NOT NULL,
  `encrtpted_password` varchar(255) NOT NULL,
  `reword_points` int(11) NOT NULL,
  `news_subscribed` bit(1) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `mobile` (`mobile`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE,
  KEY `default_address_id` (`default_address_id`),
  CONSTRAINT `default_address_id` FOREIGN KEY (`default_address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `ship_method` int(11) NOT NULL,
  `reword_points` int(11) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  `total_price` double(10,2) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `customer_id` (`customer_id`) USING BTREE,
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `order_id` int(20) DEFAULT NULL,
  `ship_method` smallint(6) NOT NULL,
  `ship_address` varchar(255) NOT NULL,
  `ship_price` double NOT NULL,
  `pay_method` smallint(6) NOT NULL,
  `invoice_address` varchar(255) DEFAULT NULL,
  `invoice_price` double NOT NULL,
  `comment` varchar(255) NOT NULL,
  `order_products` text NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_price` double NOT NULL,
  `unit_reword_points` int(11) DEFAULT NULL,
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_abstract` varchar(255) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `discoun` double DEFAULT NULL,
  `stock_quantity` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `main_pic_url` varchar(255) NOT NULL,
  `reword_points` int(11) DEFAULT NULL,
  `sort_order` int(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_code` (`product_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for productdetail
-- ----------------------------
DROP TABLE IF EXISTS `productdetail`;
CREATE TABLE `productdetail` (
  `product_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `other_pic_urls` varchar(255) NOT NULL,
  UNIQUE KEY `product_id` (`product_id`) USING BTREE,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productdetail
-- ----------------------------

-- ----------------------------
-- Table structure for return
-- ----------------------------
DROP TABLE IF EXISTS `return`;
CREATE TABLE `return` (
  `return_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(20) NOT NULL,
  `order_time` datetime DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `return_action` tinyint(4) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `opened` bit(1) NOT NULL,
  `reason` tinyint(4) NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`return_id`),
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `customer_id` (`customer_id`) USING BTREE,
  KEY `create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return
-- ----------------------------

-- ----------------------------
-- Table structure for returnhistory
-- ----------------------------
DROP TABLE IF EXISTS `returnhistory`;
CREATE TABLE `returnhistory` (
  `return_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `return_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `return_status` tinyint(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `customer_notified` bit(1) NOT NULL,
  PRIMARY KEY (`return_history_id`),
  KEY `return_id` (`return_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of returnhistory
-- ----------------------------

-- ----------------------------
-- Table structure for returnorderhistory
-- ----------------------------
DROP TABLE IF EXISTS `returnorderhistory`;
CREATE TABLE `returnorderhistory` (
  `order_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `comment` varchar(255) NOT NULL,
  `order_status` tinyint(255) NOT NULL,
  `customer_notified` bit(1) NOT NULL,
  PRIMARY KEY (`order_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of returnorderhistory
-- ----------------------------
