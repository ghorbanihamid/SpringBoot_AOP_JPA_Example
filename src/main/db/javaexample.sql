/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50524
 Source Host           : localhost:3306
 Source Schema         : javaexample

 Target Server Type    : MySQL
 Target Server Version : 50524
 File Encoding         : 65001

 Date: 18/04/2018 19:17:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `CustomerId` bigint(20) NOT NULL,
  `FirstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EmailAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PhoneNumber` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreateDate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`CustomerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1000, 'hubert', 'hubert', 'hubert@yahoo.com', '09121822492', '2018-04-17 12:13:08');
INSERT INTO `customer` VALUES (1001, 'john', 'john', 'john@yahoo.com', '09121822492', '2018-04-18 12:13:08');
INSERT INTO `customer` VALUES (1002, 'rrrr', 'rrrr', 'e@yahoo.com', '11111111', NULL);
INSERT INTO `customer` VALUES (1003, 'fff', 'fff', 'r@yahoo.com', '5555555', NULL);
INSERT INTO `customer` VALUES (1004, 'www', 'www', 'w', 'w', NULL);
INSERT INTO `customer` VALUES (1005, 'g', 'g', 'g', 'g', NULL);
INSERT INTO `customer` VALUES (1006, 'ff', 'f', 'f', 'f', NULL);

-- ----------------------------
-- Table structure for customerseq
-- ----------------------------
DROP TABLE IF EXISTS `customerseq`;
CREATE TABLE `customerseq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of customerseq
-- ----------------------------
INSERT INTO `customerseq` VALUES (1007);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `UserId` int(11) NOT NULL,
  `UserFirstName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserLastName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'hamid', 'Ghorbani', 'hamid', '123456');
INSERT INTO `userinfo` VALUES (2, 'Guest', 'User', 'test', 'test');

SET FOREIGN_KEY_CHECKS = 1;
