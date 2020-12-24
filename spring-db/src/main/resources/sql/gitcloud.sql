/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : gitcloud

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 12/08/2020 18:21:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_datasource
-- ----------------------------
DROP TABLE IF EXISTS `sys_datasource`;
CREATE TABLE `sys_datasource`  (
  `source_id` varchar(58) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datasource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updatatime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`source_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` varchar(58) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(58) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `level` int(10) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(58) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `compent` varchar(58) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(15) NULL DEFAULT 1,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', NULL, NULL, 1, 1, NULL, '/home', 'Home', '系统管理主页', 1);
INSERT INTO `sys_menu` VALUES ('2', '数据库管理', NULL, '1', 1, 2, NULL, '/datasource', 'Datasouce', '数据库管理主页', 1);
INSERT INTO `sys_menu` VALUES ('3', '用户设置', NULL, NULL, 2, 1, NULL, '/user', 'User', '用户设置主页', 1);
INSERT INTO `sys_menu` VALUES ('4', '菜单管理', NULL, '1', 2, 2, NULL, '/menu', 'Menu', '菜单管理', 1);
INSERT INTO `sys_menu` VALUES ('5', '子菜单管理', NULL, '4', 1, 3, NULL, '/childmenu', 'Childmenu', '子菜单管理', 1);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desciption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rolename` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rolecode` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `desciption` varchar(125) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'SUPER_ADMIN', '2020-08-12 15:46:48', '超级管理员角色');
INSERT INTO `sys_role` VALUES ('2', '普通用户', 'CUSTOMER', '2020-08-12 16:27:56', '普通角色');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` varchar(125) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobilephone` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(158) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '13481005618', '469@123.com', 'admin', '2020-08-12 15:43:04');
INSERT INTO `sys_user` VALUES ('2', 'll', '123456', '13481005618', '469@123.com', '韦伟', '2020-08-12 16:31:06');

-- ----------------------------
-- Table structure for sys_user_role_pk
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_pk`;
CREATE TABLE `sys_user_role_pk`  (
  `role_id` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role_pk
-- ----------------------------
INSERT INTO `sys_user_role_pk` VALUES ('1', '1');
INSERT INTO `sys_user_role_pk` VALUES ('2', '2');

SET FOREIGN_KEY_CHECKS = 1;
