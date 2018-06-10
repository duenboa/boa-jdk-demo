SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_dep
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dep`;
CREATE TABLE `tbl_dep` (
  `depId` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dep
-- ----------------------------
INSERT INTO `tbl_dep` VALUES ('01', '总公司');
INSERT INTO `tbl_dep` VALUES ('0101', '一分公司');
INSERT INTO `tbl_dep` VALUES ('010101', '开发部');
INSERT INTO `tbl_dep` VALUES ('010102', '测试部');
INSERT INTO `tbl_dep` VALUES ('0102', '二分公司');
INSERT INTO `tbl_dep` VALUES ('010201', '开发部');
INSERT INTO `tbl_dep` VALUES ('010202', '测试部');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `userId` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `depId` varchar(20) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `TBL_USER_FK` (`depId`),
  CONSTRAINT `TBL_USER_FK` FOREIGN KEY (`depId`) REFERENCES `tbl_dep` (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('user0001', '张三1', '010101', '男');
INSERT INTO `tbl_user` VALUES ('user0002', '张三2', '010101', '男');
INSERT INTO `tbl_user` VALUES ('user0003', '张三3', '010102', '男');
INSERT INTO `tbl_user` VALUES ('user0004', '张三4', '010201', '男');
INSERT INTO `tbl_user` VALUES ('user0005', '张三5', '010201', '男');
INSERT INTO `tbl_user` VALUES ('user0006', '张三6', '010102', '男');
SET FOREIGN_KEY_CHECKS=1;