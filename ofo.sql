/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : ofo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 11/27/2017 22:21:02 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `message_type`
-- ----------------------------
DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `message_type`
-- ----------------------------
BEGIN;
INSERT INTO `message_type` VALUES ('1', '好评'), ('2', '差评'), ('3', '一般'), ('4', '中等');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_bill`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_bill`;
CREATE TABLE `ofo_bill` (
  `id` int(64) NOT NULL,
  `type` char(1) DEFAULT NULL COMMENT '"0"代表进账，"1"代表出账',
  `total` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `ofo_bill`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_bill` VALUES ('1', '0', '0.3'), ('2', '0', '0.3'), ('3', '0', '0.3'), ('4', '0', '0.3'), ('5', '0', '0.3'), ('6', '1', '200'), ('7', '1', '30');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_info`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_info`;
CREATE TABLE `ofo_info` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `ofo_code` varchar(64) DEFAULT NULL COMMENT '自行车编号',
  `ofo_pass` varchar(64) DEFAULT NULL COMMENT '自行车密码',
  `location` varchar(64) DEFAULT NULL COMMENT '位置',
  `lng` varchar(64) DEFAULT NULL COMMENT '经度',
  `lat` varchar(64) DEFAULT NULL COMMENT '纬度',
  `del_flag` char(1) DEFAULT '0' COMMENT '0表示正常，1表示逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_info`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_info` VALUES ('1', 'Y0001', '0001', '北辰区', '116', '38', '0'), ('2', 'Y0002', '0002', '北辰区', '116.396574', '39.992706', '0'), ('3', 'Y0003', '0003', '北辰区', '117.2', '39.12', '0'), ('4', 'Y0004', '0004', '红桥区', '117.15', '39.17', '0'), ('6', 'Y0006', '0006', '红桥区', '117.15', '39.17', '0'), ('7', 'Y0007', '0007', '西青区', '116.396574', '39.992706', '0'), ('8', 'Y0008', '0008', '西青区', '116.396574', '39.992706', '0'), ('9', 'Y0009', '0009', '西青区', '116.396574', '39.992706', '0');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_menu`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_menu`;
CREATE TABLE `ofo_menu` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `sort` decimal(10,0) DEFAULT NULL,
  `href` varchar(64) DEFAULT NULL,
  `icon` varchar(64) DEFAULT NULL,
  `role_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_menu`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_menu` VALUES ('1', '0', '车辆管理', '0', null, 'fa fa-bicycle', '1'), ('10', '1', '车辆信息', '30', 'info?init', null, '1'), ('100', '0', '业绩查询', '0', null, 'fa fa-rmb', '4'), ('11', '1', '车辆状态', '60', 'status?init', null, '1'), ('2', '0', '故障管理', '30', null, 'fa fa-tachometer', '1'), ('21', '2', '车辆报修', '30', 'repair?init', null, '1'), ('22', '2', '车辆报废', '60', 'reject?init', null, '1'), ('3', '0', '人员管理', '60', 'userMgn?init', 'fa fa-user', '1'), ('4', '0', '客户留言', '90', 'message?init', 'fa fa-comments', '1'), ('5', '0', '统计管理', '120', 'statistics?init', 'fa fa-area-chart', '1'), ('6', '0', '财务管理', '150', 'bill?init', 'fa fa-rmb', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_message`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_message`;
CREATE TABLE `ofo_message` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `message_type` int(64) DEFAULT NULL COMMENT '留言类型',
  `message_title` varchar(64) DEFAULT NULL,
  `message_content` varchar(64) DEFAULT NULL COMMENT '"留言内容"',
  `del_flag` varchar(64) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_message`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_message` VALUES ('1', 'A', '2017-05-14 18:34:50', '2', 'aaa', 'aaaaaa', '0'), ('2', 'B', '2017-05-03 18:35:15', '2', 'bbb', 'bbbbbbbbb', '0'), ('3', 'C', '2017-05-03 18:36:04', '2', 'ccc', 'cccccccccc', '0'), ('4', 'D', '2017-05-19 18:36:18', '2', 'ddddddddddd', 'dddddddddddd', '0'), ('5', 'E', '2017-05-11 18:36:33', '3', 'eeeeeee', 'eeeeee', '0'), ('6', 'F', '2017-05-03 18:36:48', '3', 'fffffffff', 'ffffff', '0'), ('7', 'G', '2017-05-13 18:37:03', '3', 'gggggg', 'ggggg', '0'), ('8', 'H', '2017-05-04 18:37:16', '4', 'hhh', 'hhhhhhhhh', '0'), ('9', 'I', '2017-05-02 18:37:42', '4', 'iiii', 'iiiii', '0'), ('10', 'J', '2017-05-12 18:37:55', '2', 'jjj', 'jjjjjjj', '0'), ('11', 'K', '2017-05-10 18:38:08', '2', 'kkkkk', 'kkkkkk', '0'), ('12', 'L', '2017-05-10 18:38:37', '1', 'lllllllll', 'lllllll', '0'), ('13', 'M', '2017-05-03 18:38:56', '1', 'mmmmm', 'mmmmm', '0'), ('14', 'N', '2017-05-11 18:39:12', '4', 'nnnnnn', 'nnnnn', '0'), ('15', 'O', '2017-05-12 18:39:25', '2', 'oooooo', 'ooooo', '0'), ('16', 'P', '2017-05-11 18:39:39', '2', 'pppppp', 'pppppp', '0'), ('17', 'Q', '2017-05-05 18:39:55', '2', 'qqqqqq', 'qqqqq', '0'), ('18', 'R', '2017-05-11 18:40:39', '2', 'rrrrr', 'rrrrrr', '0'), ('19', 'S', '2017-05-14 18:40:59', '3', 'ssss', 'ssss', '0'), ('20', 'T', '2017-05-11 18:41:14', '2', 'ttttttt', 'tttttt', '0'), ('21', 'YSP', '2017-05-14 18:41:40', '1', '好评', '用起来很好，，，', '0'), ('22', '张三', '2017-05-14 18:42:08', '3', '不好', '用着很一般，一点都不好，差评', '0');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_role`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_role`;
CREATE TABLE `ofo_role` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_role`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_role` VALUES ('1', 'admin'), ('2', 'user'), ('3', 'repair_worker'), ('4', 'saler'), ('5', 'callback_person');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_status`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_status`;
CREATE TABLE `ofo_status` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `ofo_code` varchar(64) DEFAULT NULL,
  `ofo_status` varchar(64) DEFAULT NULL COMMENT '"1"表示正常，"2"表示故障，"3"表示报废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_status`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_status` VALUES ('1', 'Y0001', '1'), ('2', 'Y0002', '2'), ('3', 'Y0003', '2'), ('4', 'Y0004', '3'), ('6', 'Y0006', '1'), ('7', 'Y0007', '1'), ('8', 'Y0008', '1'), ('9', 'Y0009', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ofo_user`
-- ----------------------------
DROP TABLE IF EXISTS `ofo_user`;
CREATE TABLE `ofo_user` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `nick_name` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `role_id` int(64) DEFAULT NULL,
  `photo` varchar(64) DEFAULT NULL,
  `user_location` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ofo_user`
-- ----------------------------
BEGIN;
INSERT INTO `ofo_user` VALUES ('1', 'admin', 'root', 'admin', '1', 'http://localhost:8080/ofo/images/sys/admin.jpg', 'all'), ('2', 'ysp', 'YYY', 'ysp', '3', 'http://localhost:8080/ofo/images/sys/user.png', 'all'), ('3', 'worker1', 'worker1', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '北辰区'), ('4', 'worker2', 'worker2', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '北辰区'), ('5', 'worker3', 'worker3', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '红桥区'), ('6', 'worker4', 'worker4', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '红桥区'), ('7', 'worker5', 'worker5', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '西青区'), ('8', 'worker6', 'worker6', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '西青区'), ('9', 'worker7', 'worker7', '123456', '4', 'http://localhost:8080/ofo/images/sys/user.png', '和平区'), ('10', 'worker8', 'worker8', '123456', '3', 'http://localhost:8080/ofo/images/sys/user.png', '和平区'), ('13', 'saler1', 'saler1', '123456', '4', 'http://localhost:8080/ofo/images/sys/user.png', 'aa'), ('14', 'callback1', 'callback1', '123456', '5', 'http://localhost:8080/ofo/images/sys/user.png', 'aaa'), ('15', 'lhx', 'root', '123456', '1', null, null), ('16', 'yzb', 'root', '123456', '1', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `rent_record`
-- ----------------------------
DROP TABLE IF EXISTS `rent_record`;
CREATE TABLE `rent_record` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `ofo_id` int(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `rent_record`
-- ----------------------------
BEGIN;
INSERT INTO `rent_record` VALUES ('1', '2017-01-05 16:14:04', '1'), ('2', '2017-01-05 16:14:04', '2'), ('3', '2017-01-05 16:14:04', '3'), ('4', '2017-01-05 16:14:04', '4'), ('5', '2017-01-05 16:14:04', '1'), ('6', '2017-01-05 16:14:04', '1'), ('7', '2017-01-05 16:14:04', '1'), ('8', '2017-01-05 16:14:04', '1'), ('9', '2017-01-05 16:14:04', '1'), ('10', '2017-02-17 16:15:16', '1'), ('11', '2017-02-17 16:15:16', '1'), ('12', '2017-02-17 16:15:16', '1'), ('13', '2017-02-17 16:15:16', '1'), ('14', '2017-02-17 16:15:16', '2'), ('15', '2017-03-03 16:15:38', '2'), ('16', '2017-03-03 16:15:38', '2'), ('17', '2017-03-03 16:15:38', '2'), ('18', '2017-03-03 16:15:38', '2'), ('19', '2017-03-03 16:15:38', '2'), ('20', '2017-04-07 16:15:56', '2'), ('21', '2017-03-03 16:15:38', '3'), ('22', '2017-03-03 16:15:38', '3'), ('23', '2017-03-03 16:15:38', '1'), ('24', '2017-03-03 16:15:38', '1'), ('25', '2017-03-03 16:15:38', '1'), ('26', '2017-03-03 16:15:38', '1'), ('27', '2017-03-03 16:15:38', '6'), ('28', '2017-03-03 16:15:38', '6'), ('29', '2017-03-03 16:15:38', '6'), ('30', '2017-03-03 16:15:38', '6'), ('31', '2017-03-03 16:15:38', '6'), ('32', '2017-03-03 16:15:38', '6'), ('33', '2017-03-03 16:15:38', '6'), ('34', '2017-03-03 16:15:38', '4'), ('35', '2017-03-03 16:15:38', '5'), ('36', '2017-03-03 16:15:38', '7'), ('37', '2017-03-03 16:15:38', '7'), ('38', '2017-03-03 16:15:38', '7'), ('39', '2017-04-14 16:16:32', '7'), ('40', '2017-04-14 16:16:32', '7'), ('41', '2017-04-14 16:16:32', '7'), ('42', '2017-04-14 16:16:32', '7'), ('43', '2017-04-14 16:16:32', '7'), ('44', '2017-04-14 16:16:32', '5'), ('45', '2017-04-14 16:16:32', '4'), ('46', '2017-04-14 16:16:32', '3'), ('47', '2017-04-14 16:16:32', '2'), ('48', '2017-04-14 16:16:32', '1'), ('49', '2017-05-18 16:16:58', '2'), ('50', '2017-05-18 16:16:58', '4'), ('51', '2017-05-18 16:16:58', '5'), ('52', '2017-05-18 16:16:58', '66'), ('53', '2017-05-18 16:16:58', '7'), ('54', '2017-05-18 16:16:58', '5');
COMMIT;

-- ----------------------------
--  Table structure for `repair_record`
-- ----------------------------
DROP TABLE IF EXISTS `repair_record`;
CREATE TABLE `repair_record` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `ofo_id` int(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `repair_record`
-- ----------------------------
BEGIN;
INSERT INTO `repair_record` VALUES ('1', '2017-01-05 14:57:17', '1'), ('2', '2017-01-18 14:57:25', '1'), ('3', '2017-01-18 14:57:32', '1'), ('4', '2017-01-18 14:57:39', '1'), ('5', '2017-02-18 14:57:49', '2'), ('6', '2017-02-18 14:57:56', '2'), ('7', '2017-02-18 14:58:03', '2'), ('8', '2017-03-18 14:58:09', '2'), ('9', '2017-03-18 14:58:19', '3'), ('10', '2017-03-18 14:58:29', '3'), ('11', '2017-03-18 14:58:39', '3'), ('12', '2017-03-18 14:58:46', '3'), ('13', '2017-03-18 14:58:53', '4'), ('14', '2017-03-18 14:58:59', '4'), ('15', '2017-04-18 14:59:05', '5'), ('16', '2017-04-18 14:59:11', '6'), ('17', '2017-04-18 14:59:18', '7'), ('18', '2017-04-18 14:59:24', '8'), ('19', '2017-04-18 14:59:31', '8'), ('20', '2017-04-18 14:59:38', '2'), ('21', '2017-04-18 14:59:43', '1'), ('22', '2017-04-18 14:59:49', '1'), ('23', '2017-04-18 14:59:56', '4'), ('24', '2017-04-18 15:00:02', '9'), ('25', '2017-04-18 15:00:09', '7'), ('26', '2017-05-18 15:00:16', '4'), ('27', '2017-05-18 15:00:21', '4');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
