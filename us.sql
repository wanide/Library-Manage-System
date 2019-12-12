/*
 Navicat Premium Data Transfer

 Source Server         : wanide
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : us

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 12/12/2019 20:25:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookmanage
-- ----------------------------
DROP TABLE IF EXISTS `bookmanage`;
CREATE TABLE `bookmanage`  (
  `BookNo` int(255) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `Book` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `Author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者\r\n',
  `Lend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否借出',
  PRIMARY KEY (`BookNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bookmanage
-- ----------------------------
INSERT INTO `bookmanage` VALUES (1, '钢铁是怎样炼成的', '奥斯特洛夫斯基', '否');
INSERT INTO `bookmanage` VALUES (2, '西游记', '吴承恩', '是');
INSERT INTO `bookmanage` VALUES (3, '红楼梦', '曹雪芹', '是');
INSERT INTO `bookmanage` VALUES (4, '水浒传', '施耐庵', '否');
INSERT INTO `bookmanage` VALUES (5, '三国演义', '罗贯中', '是');
INSERT INTO `bookmanage` VALUES (7, '安娜卡列尼娜', '列夫托尔斯泰', '否');
INSERT INTO `bookmanage` VALUES (8, '平凡的世界', '路遥', '是');
INSERT INTO `bookmanage` VALUES (10, '战争与和平', '列夫托尔斯泰', '是');

-- ----------------------------
-- Table structure for borrowhistory
-- ----------------------------
DROP TABLE IF EXISTS `borrowhistory`;
CREATE TABLE `borrowhistory`  (
  `BookNo` int(255) NOT NULL COMMENT '书本编号',
  `Borrower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借阅人',
  `Book` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `Date` datetime(0) NOT NULL COMMENT '借阅日期',
  `Lend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借阅状态',
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '借书序列',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrowhistory
-- ----------------------------
INSERT INTO `borrowhistory` VALUES (1, '2', '钢铁是怎样炼成的', '2019-07-24 00:00:00', '借出', 22);
INSERT INTO `borrowhistory` VALUES (2, '2', '西游记', '2019-07-24 00:00:00', '借出', 23);
INSERT INTO `borrowhistory` VALUES (2, '2', '西游记', '2019-07-24 00:00:00', '退还', 24);
INSERT INTO `borrowhistory` VALUES (2, 'wanide', '西游记', '2019-07-25 00:00:00', '借出', 25);
INSERT INTO `borrowhistory` VALUES (7, '2', '安娜卡列尼娜', '2019-08-17 00:00:00', '借出', 26);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin` int(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Jerry', '000000', 'Jerry', 0);
INSERT INTO `user` VALUES ('Tom', '000000', 'tom', 0);
INSERT INTO `user` VALUES ('wanide', '000000', 'lyr', 1);

SET FOREIGN_KEY_CHECKS = 1;
