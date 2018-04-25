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

 Date: 25/04/2018 14:26:08
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
INSERT INTO `customerseq` VALUES (1018);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `EmployeeId` bigint(20) NOT NULL,
  `FirstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EmailAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PhoneNumber` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreateDate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1000, 'hubert', 'hubert', 'hubert@yahoo.com', '09121822492', '2018-04-17 12:13:08');
INSERT INTO `employee` VALUES (1004, 'Hamid', 'Ghorbani', 'ghorbani_1687@yahoo.com', '09121822492', '2018-04-24 16:58:26');

-- ----------------------------
-- Table structure for employeeseq
-- ----------------------------
DROP TABLE IF EXISTS `employeeseq`;
CREATE TABLE `employeeseq`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of employeeseq
-- ----------------------------
INSERT INTO `employeeseq` VALUES (1005);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserFirstName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserLastName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'hamid', 'Ghorbani', 'hamid', '123456');
INSERT INTO `userinfo` VALUES (2, 'Guest', 'User', 'test', 'test');

SET FOREIGN_KEY_CHECKS = 1;
