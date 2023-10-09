/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : running

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2023-10-09 20:22:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '3公里配速跑', '北田南栏杆处', '2023-10-13 19:00:00');
INSERT INTO `activity` VALUES ('2', '5公里配速跑', '北田南栏杆处', '2023-10-09 19:30:00');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论的id',
  `user_id` bigint DEFAULT NULL COMMENT '第一次发表评论的人的id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `post_id` bigint DEFAULT NULL COMMENT '对参加该活动人的评论进行评论',
  `activity_id` bigint DEFAULT NULL COMMENT '评论活动的id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `articleid` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('43', '15', 'springboot', '2023-10-02 22:09:32', '2023-10-07 18:01:46', '5', '1');

-- ----------------------------
-- Table structure for `credit`
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` bigint NOT NULL COMMENT '积分id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `credits` int DEFAULT NULL COMMENT '用户积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of credit
-- ----------------------------
INSERT INTO `credit` VALUES ('1', '4', '3');
INSERT INTO `credit` VALUES ('2', '5', '4');
INSERT INTO `credit` VALUES ('3', '6', '1');
INSERT INTO `credit` VALUES ('4', '7', '77');
INSERT INTO `credit` VALUES ('5', '8', '4');
INSERT INTO `credit` VALUES ('6', '9', '12');
INSERT INTO `credit` VALUES ('7', '10', '45');
INSERT INTO `credit` VALUES ('8', '11', '55');
INSERT INTO `credit` VALUES ('9', '12', '7');
INSERT INTO `credit` VALUES ('10', '13', '13');
INSERT INTO `credit` VALUES ('11', '14', '3');
INSERT INTO `credit` VALUES ('12', '15', '5');

-- ----------------------------
-- Table structure for `sign`
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '打卡位置',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '打卡时间',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sign
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL COMMENT '管理员者1 普通用户0',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'hyxhn', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('5', 'hyxhn1', null, null, null, null, null, '123456');
INSERT INTO `user` VALUES ('6', 'hyxhn2', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('7', 'hyxhn3', null, null, null, null, null, '123456');
INSERT INTO `user` VALUES ('8', 'hyxhn4', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('9', 'hyxhn5', null, null, null, null, null, '123456');
INSERT INTO `user` VALUES ('10', 'hyxhn6', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('11', 'hyxhn7', null, null, null, null, null, '123456');
INSERT INTO `user` VALUES ('12', 'hyxhn8', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('13', 'hyxhn9', null, null, null, null, null, '123456');
INSERT INTO `user` VALUES ('14', 'hyxhn10', null, null, null, null, null, 'password');
INSERT INTO `user` VALUES ('15', 'hyxhn12', null, null, null, '2023-10-04 17:49:31', null, 'password');
INSERT INTO `user` VALUES ('16', 'hyxhn13', null, null, null, '2023-10-04 17:51:29', null, '123456789');
INSERT INTO `user` VALUES ('17', 'ls', null, null, null, '2023-10-09 19:00:14', null, '123456');

-- ----------------------------
-- Table structure for `user_activity_realtion`
-- ----------------------------
DROP TABLE IF EXISTS `user_activity_realtion`;
CREATE TABLE `user_activity_realtion` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `activity_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_activity_realtion
-- ----------------------------
INSERT INTO `user_activity_realtion` VALUES ('1710983107774582785', '15', '1');
