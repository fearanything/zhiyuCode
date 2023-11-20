
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `M_PROJECT_ID`
-- ----------------------------
DROP TABLE IF EXISTS `M_PROJECT_ID`;
CREATE TABLE `M_PROJECT_ID` (
 		`M_PROJECT_ID_ID` varchar(100) NOT NULL,
		`M_PROJECT_ORG` varchar(255) DEFAULT NULL COMMENT '项目和所属单位关联',
		`PROJECT_ID` varchar(255) DEFAULT NULL COMMENT '项目id，实际上也是org_id',
		`ORG_ID` varchar(255) DEFAULT NULL COMMENT 'orgid',
  		PRIMARY KEY (`M_PROJECT_ID_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
