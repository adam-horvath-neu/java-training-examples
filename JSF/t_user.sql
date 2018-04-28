/*
Navicat PGSQL Data Transfer

Source Server         : dobedu local
Source Server Version : 90605
Source Host           : localhost:5432
Source Database       : training
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90605
File Encoding         : 65001

Date: 2018-04-28 16:30:14
*/


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user";
CREATE TABLE "public"."t_user" (
"id" int4 DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
"username" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default",
"gender" varchar(255) COLLATE "default",
"image" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE "public"."t_user" ADD PRIMARY KEY ("id");
