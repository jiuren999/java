/*
 Navicat Premium Data Transfer

 Source Server         : new mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : edu_manage

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 30/06/2021 18:59:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classID` int(11) NOT NULL,
  `className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `majorID` int(11) NOT NULL,
  PRIMARY KEY (`classID`) USING BTREE,
  INDEX `majorID`(`majorID`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`majorID`) REFERENCES `major` (`majorID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '19计算机科学与技术(1)班', 1);
INSERT INTO `class` VALUES (2, '19计算机科学与技术(2)班', 1);
INSERT INTO `class` VALUES (3, '19数字媒体技术(1)班', 2);
INSERT INTO `class` VALUES (4, '19智能科学与技术(1)班', 3);
INSERT INTO `class` VALUES (5, '19应用经济学(1)班', 4);
INSERT INTO `class` VALUES (6, '19工商管理(全英班)', 5);
INSERT INTO `class` VALUES (7, '19金融学(1)', 6);
INSERT INTO `class` VALUES (8, '19金融学(2)', 6);
INSERT INTO `class` VALUES (9, '19服装设计与工程(1)', 7);
INSERT INTO `class` VALUES (10, '19服装设计与工程(1)', 7);
INSERT INTO `class` VALUES (11, '19服装与服饰设计(1)', 8);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseID` int(11) NOT NULL,
  `courseName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hours` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cpno` int(11) NULL DEFAULT NULL,
  `teachID` int(11) NOT NULL,
  PRIMARY KEY (`courseID`) USING BTREE,
  INDEX `teachID`(`teachID`) USING BTREE,
  INDEX `cpno`(`cpno`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teachID`) REFERENCES `teacher` (`teachID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`cpno`) REFERENCES `course` (`courseID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据库', '周三6、7、8', '48', '3', 3, 1005);
INSERT INTO `course` VALUES (2, '高等数学', '周二3、4、5', '64', '4', NULL, 1002);
INSERT INTO `course` VALUES (3, '数据结构', '周二1、2', '64', '3', NULL, 1013);
INSERT INTO `course` VALUES (4, '概论', '周一1、2', '48', '3', NULL, 1012);
INSERT INTO `course` VALUES (5, '英语', '周五3、4', '48', '3', NULL, 1008);
INSERT INTO `course` VALUES (6, '社会实践', '周五8、9', '24', '3', NULL, 1014);
INSERT INTO `course` VALUES (7, '形势与政策', '周三1、2', '8', '2', NULL, 1004);
INSERT INTO `course` VALUES (8, '概率论', '周四3、4、5', '48', '3', NULL, 1007);

-- ----------------------------
-- Table structure for depratment
-- ----------------------------
DROP TABLE IF EXISTS `depratment`;
CREATE TABLE `depratment`  (
  `deptID` int(11) NOT NULL,
  `deptName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`deptID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depratment
-- ----------------------------
INSERT INTO `depratment` VALUES (1, '信息学院', '浙江理工大学');
INSERT INTO `depratment` VALUES (2, '经济管理学院', '浙江理工大学');
INSERT INTO `depratment` VALUES (3, '服装学院', '浙江理工大学');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `majorID` int(11) NOT NULL,
  `majorName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deptID` int(11) NOT NULL,
  PRIMARY KEY (`majorID`) USING BTREE,
  INDEX `deptID`(`deptID`) USING BTREE,
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`deptID`) REFERENCES `depratment` (`deptID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '计算机科学与技术', 1);
INSERT INTO `major` VALUES (2, '数字媒体技术', 1);
INSERT INTO `major` VALUES (3, '智能科学与技术', 1);
INSERT INTO `major` VALUES (4, '应用经济学', 2);
INSERT INTO `major` VALUES (5, '工商管理', 2);
INSERT INTO `major` VALUES (6, '金融学', 2);
INSERT INTO `major` VALUES (7, '服装设计与工程', 3);
INSERT INTO `major` VALUES (8, '服装与服饰设计', 3);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `userID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `grade` char(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userID`, `courseID`) USING BTREE,
  INDEX `courseID`(`courseID`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `student` (`userID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (20190001, 1, '80');
INSERT INTO `sc` VALUES (20190001, 3, '81');
INSERT INTO `sc` VALUES (20190002, 4, '90');
INSERT INTO `sc` VALUES (20190003, 1, '77');
INSERT INTO `sc` VALUES (20190003, 8, '88');
INSERT INTO `sc` VALUES (20190004, 1, '85');
INSERT INTO `sc` VALUES (20190005, 6, '88');
INSERT INTO `sc` VALUES (20190006, 2, '94');
INSERT INTO `sc` VALUES (20190007, 3, '91');
INSERT INTO `sc` VALUES (20190008, 3, '89');
INSERT INTO `sc` VALUES (20190009, 4, '85');
INSERT INTO `sc` VALUES (20190010, 5, '88');
INSERT INTO `sc` VALUES (20190011, 8, '89');
INSERT INTO `sc` VALUES (20190012, 7, '82');
INSERT INTO `sc` VALUES (20190012, 8, '77');
INSERT INTO `sc` VALUES (20190013, 6, '87');
INSERT INTO `sc` VALUES (20190015, 2, '92');
INSERT INTO `sc` VALUES (20190016, 4, '86');
INSERT INTO `sc` VALUES (20190016, 5, '85');
INSERT INTO `sc` VALUES (20190017, 4, '90');
INSERT INTO `sc` VALUES (20190018, 6, '75');
INSERT INTO `sc` VALUES (20190018, 7, '90');

-- ----------------------------
-- Table structure for setup
-- ----------------------------
DROP TABLE IF EXISTS `setup`;
CREATE TABLE `setup`  (
  `teachID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `startTime` date NOT NULL,
  `endTime` date NOT NULL,
  PRIMARY KEY (`teachID`, `courseID`) USING BTREE,
  INDEX `courseID`(`courseID`) USING BTREE,
  CONSTRAINT `setup_ibfk_1` FOREIGN KEY (`teachID`) REFERENCES `teacher` (`teachID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `setup_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setup
-- ----------------------------
INSERT INTO `setup` VALUES (1002, 2, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1004, 7, '2021-05-02', '2021-06-13');
INSERT INTO `setup` VALUES (1005, 1, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1007, 8, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1008, 5, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1012, 4, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1013, 3, '2021-02-18', '2021-06-13');
INSERT INTO `setup` VALUES (1014, 6, '2021-05-23', '2021-06-20');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `userID` int(11) NOT NULL COMMENT '学号',
  `userName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `userSex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `userage` int(2) NOT NULL COMMENT '年龄',
  `markYear` date NOT NULL COMMENT '入学年份',
  `classID` int(11) NOT NULL COMMENT '班号',
  `teachID` int(11) NULL DEFAULT NULL COMMENT '导师',
  PRIMARY KEY (`userID`) USING BTREE,
  INDEX `classID`(`classID`) USING BTREE,
  INDEX `student_ibfk_2`(`teachID`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `class` (`classID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`teachID`) REFERENCES `teacher` (`teachID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20190001, '王平', '男', 20, '2019-09-01', 2, 1004);
INSERT INTO `student` VALUES (20190002, '李勇', '男', 21, '2019-09-01', 9, NULL);
INSERT INTO `student` VALUES (20190003, '刘晨', '男', 20, '2019-09-01', 1, 1004);
INSERT INTO `student` VALUES (20190004, '王名', '男', 19, '2019-09-01', 3, NULL);
INSERT INTO `student` VALUES (20190005, '张立', '男', 20, '2019-09-01', 2, NULL);
INSERT INTO `student` VALUES (20190006, '李明', '男', 20, '2019-09-01', 10, 1011);
INSERT INTO `student` VALUES (20190007, '张小梅', '女', 19, '2019-09-01', 1, NULL);
INSERT INTO `student` VALUES (20190008, '封晓文', '女', 20, '2019-09-01', 3, NULL);
INSERT INTO `student` VALUES (20190009, '陈冬', '男', 20, '2019-09-01', 4, 1001);
INSERT INTO `student` VALUES (20190010, '风清扬', '男', 20, '2019-09-01', 4, 1002);
INSERT INTO `student` VALUES (20190011, '黄明', '男', 19, '2019-09-01', 7, 1009);
INSERT INTO `student` VALUES (20190012, '张亚', '女', 20, '2019-09-01', 6, 1007);
INSERT INTO `student` VALUES (20190013, '朱洋', '男', 20, '2019-09-01', 5, NULL);
INSERT INTO `student` VALUES (20190014, '章维', '男', 20, '2019-09-01', 8, 1012);
INSERT INTO `student` VALUES (20190015, '赵仪', '女', 21, '2019-09-01', 9, NULL);
INSERT INTO `student` VALUES (20190016, '刘威', '男', 20, '2019-09-01', 7, 1012);
INSERT INTO `student` VALUES (20190017, '武岳', '男', 19, '2019-09-01', 11, 1011);
INSERT INTO `student` VALUES (20190018, '任倩', '女', 20, '2019-09-01', 10, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teachID` int(11) NOT NULL,
  `teachName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teachSex` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teachAge` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `degree` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teachYear` date NOT NULL,
  `roomID` int(11) NOT NULL,
  PRIMARY KEY (`teachID`) USING BTREE,
  INDEX `roomID`(`roomID`) USING BTREE,
  INDEX `teachID`(`teachID`, `roomID`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`roomID`) REFERENCES `teacher_room` (`roomID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1001, '刘文', '女', '40', '硕士', '副教授', '2005-04-08', 3);
INSERT INTO `teacher` VALUES (1002, '王萍', '女', '45', '博士', '教授', '2004-03-26', 3);
INSERT INTO `teacher` VALUES (1003, '黄鄂', '男', '39', '硕士', '助教', '2009-07-18', 2);
INSERT INTO `teacher` VALUES (1004, '陈珂', '女', '35', '本科', '讲师', '2009-03-06', 1);
INSERT INTO `teacher` VALUES (1005, '赵洋', '男', '42', '硕士', '副教授', '2007-03-23', 2);
INSERT INTO `teacher` VALUES (1006, '孙逸', '男', '42', '硕士', '副教授', '2008-08-16', 7);
INSERT INTO `teacher` VALUES (1007, '王品', '男', '36', '本科', '讲师', '2012-03-15', 5);
INSERT INTO `teacher` VALUES (1008, '彭建国', '男', '40', '硕士', '副教授', '2010-05-22', 4);
INSERT INTO `teacher` VALUES (1009, '张若克', '男', '32', '硕士', '讲师', '2015-10-17', 6);
INSERT INTO `teacher` VALUES (1010, '陈玲', '女', '35', '硕士', '助教', '2015-12-24', 7);
INSERT INTO `teacher` VALUES (1011, '郭赞', '女', '38', '硕士', '副教授', '2011-07-23', 8);
INSERT INTO `teacher` VALUES (1012, '朱杰', '男', '42', '博士', '教授', '2007-03-08', 6);
INSERT INTO `teacher` VALUES (1013, '李芮', '女', '40', '博士', '教授', '2006-06-08', 1);
INSERT INTO `teacher` VALUES (1014, '罗源', '男', '34', '硕士', '讲师', '2011-06-14', 4);
INSERT INTO `teacher` VALUES (1015, '沈轩', '男', '36', '硕士', '讲师', '2012-10-10', 5);

-- ----------------------------
-- Table structure for teacher_room
-- ----------------------------
DROP TABLE IF EXISTS `teacher_room`;
CREATE TABLE `teacher_room`  (
  `roomID` int(11) NOT NULL,
  `roomName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deptID` int(11) NOT NULL,
  PRIMARY KEY (`roomID`) USING BTREE,
  INDEX `deptID`(`deptID`) USING BTREE,
  CONSTRAINT `teacher_room_ibfk_1` FOREIGN KEY (`deptID`) REFERENCES `depratment` (`deptID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_room
-- ----------------------------
INSERT INTO `teacher_room` VALUES (1, '计科教研室', 1);
INSERT INTO `teacher_room` VALUES (2, '数媒教研室', 1);
INSERT INTO `teacher_room` VALUES (3, '智科教研室', 1);
INSERT INTO `teacher_room` VALUES (4, '应用经济教研室', 2);
INSERT INTO `teacher_room` VALUES (5, '工商管理教研室', 2);
INSERT INTO `teacher_room` VALUES (6, '金融教研室', 2);
INSERT INTO `teacher_room` VALUES (7, '服工教研室', 3);
INSERT INTO `teacher_room` VALUES (8, '服设教研室', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `upass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `u_name`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `user` VALUES (2, '李思影', 'lay', 2);
INSERT INTO `user` VALUES (3, '高原', 'gy', 2);
INSERT INTO `user` VALUES (4, '肖畅', 'xc', 2);
INSERT INTO `user` VALUES (5, '佟静林', 'tjl', 2);
INSERT INTO `user` VALUES (6, '邵永刚', 'syg', 2);
INSERT INTO `user` VALUES (7, '20190001', '0001', 2);
INSERT INTO `user` VALUES (8, '20190002', '0002', 2);
INSERT INTO `user` VALUES (9, '20190003', '0003', 2);
INSERT INTO `user` VALUES (10, '20190004', '0004', 2);
INSERT INTO `user` VALUES (11, '20190005', '0005', 2);
INSERT INTO `user` VALUES (12, '1001', '1001', 3);
INSERT INTO `user` VALUES (13, '1002', '1002', 3);
INSERT INTO `user` VALUES (14, '1003', '1003', 3);
INSERT INTO `user` VALUES (15, '20190006', '0006', 2);

-- ----------------------------
-- View structure for student_information
-- ----------------------------
DROP VIEW IF EXISTS `student_information`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `student_information` AS select `student`.`userID` AS `userID`,`student`.`userName` AS `userName`,`student`.`userSex` AS `userSex`,`student`.`userage` AS `userage`,`student`.`markYear` AS `markYear`,`class`.`className` AS `className`,`major`.`majorName` AS `majorName`,`depratment`.`deptName` AS `deptName`,`depratment`.`stuName` AS `stuName` from (((`student` join `class`) join `major`) join `depratment`) where ((`student`.`classID` = `class`.`classID`) and (`class`.`majorID` = `major`.`majorID`) and (`major`.`deptID` = `depratment`.`deptID`));

-- ----------------------------
-- View structure for student_sc_grade
-- ----------------------------
DROP VIEW IF EXISTS `student_sc_grade`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `student_sc_grade` AS select `student`.`userID` AS `userID`,`student`.`userName` AS `userName`,`class`.`className` AS `className`,`course`.`courseName` AS `courseName`,`teacher`.`teachName` AS `teachName`,`course`.`time` AS `time`,`sc`.`grade` AS `grade`,`setup`.`startTime` AS `startTime`,`setup`.`endTime` AS `endTime` from (((((`student` join `class`) join `sc`) join `course`) join `teacher`) join `setup`) where ((`student`.`classID` = `class`.`classID`) and (`sc`.`userID` = `student`.`userID`) and (`sc`.`courseID` = `course`.`courseID`) and (`course`.`teachID` = `teacher`.`teachID`) and (`teacher`.`teachID` = `setup`.`teachID`) and (`setup`.`courseID` = `course`.`courseID`));

-- ----------------------------
-- View structure for teacher_information
-- ----------------------------
DROP VIEW IF EXISTS `teacher_information`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_information` AS select `teacher`.`teachID` AS `teachID`,`teacher`.`teachName` AS `teachName`,`teacher`.`teachSex` AS `teachSex`,`teacher`.`teachAge` AS `teachAge`,`teacher`.`degree` AS `degree`,`teacher`.`title` AS `title`,`teacher`.`teachYear` AS `teachYear`,`teacher_room`.`roomName` AS `roomName`,`depratment`.`deptName` AS `deptName`,`depratment`.`stuName` AS `stuName` from ((`teacher` join `teacher_room`) join `depratment`) where ((`teacher`.`roomID` = `teacher_room`.`roomID`) and (`teacher_room`.`deptID` = `depratment`.`deptID`));

-- ----------------------------
-- View structure for teacher_sc
-- ----------------------------
DROP VIEW IF EXISTS `teacher_sc`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_sc` AS select `teacher`.`teachID` AS `teachID`,`teacher`.`teachName` AS `teachName`,`course`.`courseName` AS `courseName`,`course`.`time` AS `time`,`course`.`hours` AS `hours`,`setup`.`startTime` AS `startTime`,`setup`.`endTime` AS `endTime` from ((`teacher` join `course`) join `setup`) where ((`teacher`.`teachID` = `setup`.`teachID`) and (`course`.`courseID` = `setup`.`courseID`));

-- ----------------------------
-- View structure for teacher_student
-- ----------------------------
DROP VIEW IF EXISTS `teacher_student`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_student` AS select `teacher`.`teachID` AS `teachID`,`student`.`userName` AS `userName`,`class`.`className` AS `className`,`course`.`courseName` AS `courseName`,`teacher`.`teachName` AS `teachName`,`course`.`time` AS `time`,`sc`.`grade` AS `grade`,`setup`.`startTime` AS `startTime`,`setup`.`endTime` AS `endTime` from (((((`student` join `class`) join `sc`) join `course`) join `teacher`) join `setup`) where ((`student`.`classID` = `class`.`classID`) and (`sc`.`userID` = `student`.`userID`) and (`sc`.`courseID` = `course`.`courseID`) and (`course`.`teachID` = `teacher`.`teachID`) and (`teacher`.`teachID` = `setup`.`teachID`) and (`setup`.`courseID` = `course`.`courseID`));

SET FOREIGN_KEY_CHECKS = 1;
