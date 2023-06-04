/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : db_hotel

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-01-07 22:00:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_buy`
-- ----------------------------
DROP TABLE IF EXISTS `tb_buy`;
CREATE TABLE `tb_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `bstate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_buy
-- ----------------------------
INSERT INTO `tb_buy` VALUES ('3', 'aa', '红烧肉', 'hsr', '盘', '30', '1', '30', '');
INSERT INTO `tb_buy` VALUES ('4', '100102', '青菜', 'qc', '盘', '10', '1', '10', '');
INSERT INTO `tb_buy` VALUES ('5', '100101', '红烧肉', 'hsr', '盘', '30', '1', '30', '');

-- ----------------------------
-- Table structure for `tb_desk`
-- ----------------------------
DROP TABLE IF EXISTS `tb_desk`;
CREATE TABLE `tb_desk` (
  `num` varchar(255) NOT NULL DEFAULT '',
  `seating` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_desk
-- ----------------------------
INSERT INTO `tb_desk` VALUES ('1001', '8');
INSERT INTO `tb_desk` VALUES ('1002', '6');
INSERT INTO `tb_desk` VALUES ('1003', '4');
INSERT INTO `tb_desk` VALUES ('1004', '4');
INSERT INTO `tb_desk` VALUES ('1005', '2');

-- ----------------------------
-- Table structure for `tb_deskuse`
-- ----------------------------
DROP TABLE IF EXISTS `tb_deskuse`;
CREATE TABLE `tb_deskuse` (
  `num` varchar(255) DEFAULT NULL,
  `seating` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_deskuse
-- ----------------------------
INSERT INTO `tb_deskuse` VALUES ('1001', '0', '1');
INSERT INTO `tb_deskuse` VALUES ('1002', '0', '2');
INSERT INTO `tb_deskuse` VALUES ('1001', '0', '3');

-- ----------------------------
-- Table structure for `tb_goods`
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `num` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `gnum` int(11) DEFAULT NULL,
  `gumoney` int(11) DEFAULT NULL,
  `gtotal` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('p100101', '苹果', '250', '6', '1500');
INSERT INTO `tb_goods` VALUES ('q100104', '青菜', '200', '2', '400');
INSERT INTO `tb_goods` VALUES ('s100102', '大蒜', '350', '1', '350');
INSERT INTO `tb_goods` VALUES ('x100103', '西瓜', '60', '20', '1200');

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `num` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('100101', '红烧肉', 'hsr', '盘', '30', '1', '30');
INSERT INTO `tb_menu` VALUES ('100102', '青菜', 'qc', '盘', '10', '1', '10');
INSERT INTO `tb_menu` VALUES ('100103', '狮子头', 'szt', '盘', '30', '1', '30');
INSERT INTO `tb_menu` VALUES ('100104', '土豆丝', 'tds', '盘', '15', '1', '15');

-- ----------------------------
-- Table structure for `tb_sort`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sort`;
CREATE TABLE `tb_sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sort
-- ----------------------------
INSERT INTO `tb_sort` VALUES ('1', '川菜');
INSERT INTO `tb_sort` VALUES ('2', '粤菜');
INSERT INTO `tb_sort` VALUES ('3', '徽菜');
INSERT INTO `tb_sort` VALUES ('4', '卤菜');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `freeze` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('4', '何明辉', '男', '22', 'hmh_123', '234', '1_23');
INSERT INTO `tb_user` VALUES ('5', '王可', '女', '11', 'wk_123', '1234', '1_234');
