-- ----------------------------
-- Table structure for "C##FHADMIN"."M_PROJECT_ID"
-- ----------------------------
-- DROP TABLE "C##FHADMIN"."M_PROJECT_ID";
CREATE TABLE "C##FHADMIN"."M_PROJECT_ID" (
	"M_PROJECT_ORG" VARCHAR2(255 BYTE) NULL ,
	"PROJECT_ID" VARCHAR2(255 BYTE) NULL ,
	"ORG_ID" VARCHAR2(255 BYTE) NULL ,
	"M_PROJECT_ID_ID" VARCHAR2(100 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE
;

COMMENT ON COLUMN "C##FHADMIN"."M_PROJECT_ID"."M_PROJECT_ORG" IS '项目和所属单位关联';
COMMENT ON COLUMN "C##FHADMIN"."M_PROJECT_ID"."PROJECT_ID" IS '项目id，实际上也是org_id';
COMMENT ON COLUMN "C##FHADMIN"."M_PROJECT_ID"."ORG_ID" IS 'orgid';
COMMENT ON COLUMN "C##FHADMIN"."M_PROJECT_ID"."M_PROJECT_ID_ID" IS 'ID';

-- ----------------------------
-- Indexes structure for table M_PROJECT_ID
-- ----------------------------

-- ----------------------------
-- Checks structure for table "C##FHADMIN"."M_PROJECT_ID"

-- ----------------------------

ALTER TABLE "C##FHADMIN"."M_PROJECT_ID" ADD CHECK ("M_PROJECT_ID_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "C##FHADMIN"."M_PROJECT_ID"
-- ----------------------------
ALTER TABLE "C##FHADMIN"."M_PROJECT_ID" ADD PRIMARY KEY ("M_PROJECT_ID_ID");
