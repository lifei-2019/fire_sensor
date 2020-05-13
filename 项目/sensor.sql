/*
Navicat MySQL Data Transfer

Source Server         : 47.106.172.7_zhaoh
Source Server Version : 50723
Source Host           : 47.106.172.7:3306
Source Database       : sensor

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-19 13:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `device_name` varchar(500) DEFAULT NULL COMMENT '设备名称',
  `device_type` varchar(500) DEFAULT NULL COMMENT '设备类型',
  `create_user` varchar(200) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for fire
-- ----------------------------
DROP TABLE IF EXISTS `fire`;
CREATE TABLE `fire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fire_temp` double NOT NULL COMMENT '温度',
  `fire_hum` double NOT NULL COMMENT '湿度',
  `fire_fog` double NOT NULL COMMENT '浓度',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_admin` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


INSERT into userinfo(user_name, password) values ('test','11');