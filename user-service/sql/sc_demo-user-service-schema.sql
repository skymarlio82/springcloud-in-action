DROP DATABASE IF EXISTS sc_demo_user;

CREATE DATABASE IF NOT EXISTS sc_demo_user;

USE sc_demo_user;

-- ==============================
-- Table of SCD_USER_PROFILE_TAB
-- ==============================

DROP TABLE IF EXISTS scd_user_profile_tab;

CREATE TABLE IF NOT EXISTS scd_user_profile_tab (
	id INT NOT NULL AUTO_INCREMENT, 
	username VARCHAR(30) NOT NULL, 
	password VARCHAR(100) NOT NULL, 
	CONSTRAINT pk_scd_user_profile_tab PRIMARY KEY (id)
)
DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci
ENGINE=InnoDB
COMMENT='SCD: User Profile Entity';

CREATE INDEX idx_username_2_scd_user_profile_tab ON scd_user_profile_tab (username);