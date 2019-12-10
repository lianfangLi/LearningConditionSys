/*
 Navicat Premium Data Transfer

 Source Server         : LF
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : learning_condition_sys

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 09/12/2019 10:28:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attending
-- ----------------------------
DROP TABLE IF EXISTS `attending`;
CREATE TABLE `attending`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `which_subject` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `which_time` int(11) NOT NULL,
  `which_term` enum('第一学期','第二学期') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学期',
  `which_year` enum('第一学年','第二学年','第三学年','第四学年') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学年',
  `class_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_attend` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`, `which_subject`, `which_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考勤表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attending
-- ----------------------------
INSERT INTO `attending` VALUES ('17111205002', '17111', 1, '第一学期', '第一学年', '1', '0');
INSERT INTO `attending` VALUES ('17111205002', '17111', 2, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17111', 3, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17111', 4, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17111', 5, '第一学期', '第一学年', '1', '0');
INSERT INTO `attending` VALUES ('17111205002', '17111', 6, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17112', 1, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17112', 2, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205002', '17112', 3, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 1, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 2, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 3, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 4, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 5, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17111', 6, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17112', 1, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17112', 2, '第一学期', '第一学年', '1', '1');
INSERT INTO `attending` VALUES ('17111205003', '17112', 3, '第一学期', '第一学年', '1', '1');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_no` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班号',
  `class_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班名',
  `year` datetime(0) NULL DEFAULT NULL COMMENT '入学年份',
  `number` int(11) NULL DEFAULT 0,
  `dp_id` int(11) NULL DEFAULT NULL,
  `teacher_no` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`class_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '物联网', '2017-09-01 08:00:00', 50, 17111205, 'Susan');
INSERT INTO `class` VALUES ('24', '软件工程', '2017-09-01 08:00:00', 50, 17111205, 'Susan');
INSERT INTO `class` VALUES ('3', '计算机', '2017-09-01 08:00:00', 50, 17111205, 'Susan');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cour_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cour_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` float(5, 4) NULL DEFAULT NULL,
  `period` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cour_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('17111', '高等数学', 3.0000, 64);
INSERT INTO `course` VALUES ('17112', '概率论', 1.0000, 64);
INSERT INTO `course` VALUES ('3', '线性代数', 2.0000, 64);
INSERT INTO `course` VALUES ('4', '操作系统', 4.0000, 1);
INSERT INTO `course` VALUES ('6567', '高等数学', 2.0000, 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dp_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dp_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dp_head` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '软件', 'jerry');
INSERT INTO `department` VALUES ('2', '数学', 'bob');
INSERT INTO `department` VALUES ('3', '物理', 'jack');

-- ----------------------------
-- Table structure for final_grade
-- ----------------------------
DROP TABLE IF EXISTS `final_grade`;
CREATE TABLE `final_grade`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  `class_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生班级号',
  `cour_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程号',
  `year` enum('第一学年','第二学年','第三学年','第四学年') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学年',
  `term` enum('第一学期','第二学期') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学期',
  `check_class_attendance` float(6, 3) NULL DEFAULT 0.000 COMMENT '考勤成绩',
  `check_homeawork_attendance` float(6, 3) NULL DEFAULT 0.000 COMMENT '作业成绩',
  `mid_exam` float(6, 3) NULL DEFAULT 0.000,
  `last_exam` float(6, 3) NULL DEFAULT 0.000 COMMENT '期末成绩',
  `grades` float(6, 3) NULL DEFAULT 0.000 COMMENT '最终成绩',
  PRIMARY KEY (`id`, `class_no`, `cour_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of final_grade
-- ----------------------------
INSERT INTO `final_grade` VALUES ('17111205005', '1', '17111', '第一学年', '第一学期', 0.000, 0.000, 0.000, 10.000, 0.000);
INSERT INTO `final_grade` VALUES ('17111205006', '1', '17111', '第一学年', '第一学期', 0.000, 0.000, 0.000, 100.000, 0.000);

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `which_subject` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `which_time` int(11) NOT NULL,
  `which_term` enum('第一学期','第二学期') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `which_year` enum('第一学年','第二学年','第三学年','第四学年') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学年',
  `class_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_attend` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`id`, `which_subject`, `which_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sd_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男',
  `birth` date NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `contact` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mood` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_no` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('17111205000', 'James', '男', '2019-11-18', 19, '16688882222', '123@163.com', 'Holy!', '12');
INSERT INTO `student` VALUES ('17111205001', 'Jack', '男', '2019-11-18', 19, '1668882222', '123@163.com', 'Holy!', '2');
INSERT INTO `student` VALUES ('17111205002', 'Ricky', '男', '2019-11-18', 19, '16688882', '123@163.com', 'FFFFF!', '12');
INSERT INTO `student` VALUES ('17111205003', 'Michal', '女', '2019-11-18', 19, '1668882222', '123@163.com', 'Holy!', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男',
  `birth` date NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `contact` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mood` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` enum('教授','副教授','讲师','助教') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '助教',
  `dp_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('17111', '马', '男', '2019-12-22', 56, '13888885555', 'whatever@163.com', 'what’s this？', '教授', 1);
INSERT INTO `teacher` VALUES ('17112', '李', '男', '2019-12-22', 56, '13888885555', 'whatever@163.com', 'what’s this？', '教授', 1);

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course`  (
  `teacher_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cour_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cour_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` enum('第一学年','第二学年','第三学年','第四学年','') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '第一学年',
  `term` enum('第一学期','第二学期') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`, `class_name`, `cour_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('17111', '2', '软件工程', '1', '高等数学', '第一学年', '第一学期');
INSERT INTO `teacher_course` VALUES ('17111', '24', '软件工程', '17112', '概率论', '第一学年', '第一学期');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pass` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` enum('stu','tea','col','adm') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'stu',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1234', 'stu');
INSERT INTO `user` VALUES ('16111', 'thisismypass', 'tea');

SET FOREIGN_KEY_CHECKS = 1;
