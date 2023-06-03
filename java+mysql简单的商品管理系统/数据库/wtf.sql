/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : wtf

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-03-20 00:59:20
*/


CREATE DATABASE IF NOT EXISTS wtf
DEFAULT CHARACTER SET utf8;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
use wtf;
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `sno` varchar(20) NOT NULL,
  `sname` varchar(40) NOT NULL,
  `sprice` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('001', '伊利多', '2.5');
INSERT INTO `info` VALUES ('002', '巧克力', '4');
INSERT INTO `info` VALUES ('003', '奥利奥', '11');
INSERT INTO `info` VALUES ('201', '酸奶', '30');
INSERT INTO `info` VALUES ('201402', '薯片', '30');
INSERT INTO `info` VALUES ('2411', '棒棒糖', '7');
