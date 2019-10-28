/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : 127.0.0.1:3306
 Source Schema         : consume_manager

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 28/10/2019 23:00:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_url_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_url_permission`;
CREATE TABLE `sys_url_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_id` int(255) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `url_permission_url_id`(`url_id`) USING BTREE,
  INDEX `url_permission_permission_id`(`permission_id`) USING BTREE,
  CONSTRAINT `url_permission_url_id` FOREIGN KEY (`url_id`) REFERENCES `sys_url` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `url_permission_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
