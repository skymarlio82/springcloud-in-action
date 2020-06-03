DROP DATABASE IF EXISTS sc_demo_user;

CREATE DATABASE IF NOT EXISTS sc_demo_user;

USE sc_demo_user;

-- ==============================
-- Table of scd_user_profile_tab
-- ==============================

DROP TABLE IF EXISTS scd_user_profile_tab;

CREATE TABLE IF NOT EXISTS scd_user_profile_tab (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,
	enabled BOOLEAN NOT NULL,
	lastpasswordresetdate TIMESTAMP NOT NULL,
	CONSTRAINT pk_scd_user_profile_tab PRIMARY KEY (id)
)
DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci
ENGINE=InnoDB
COMMENT='SCD: User Profile Entity';

CREATE INDEX idx_username_2_scd_user_profile_tab ON scd_user_profile_tab (username);

-- ===========================
-- Table of scd_authority_tab
-- ===========================

DROP TABLE IF EXISTS scd_authority_tab;

CREATE TABLE IF NOT EXISTS scd_authority_tab (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	CONSTRAINT pk_scd_authority_tab PRIMARY KEY (id)
)
DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci
ENGINE=InnoDB
COMMENT='SCD: User Authority Entity';

-- ================================
-- Table of scd_user_authority_tab
-- ================================

DROP TABLE IF EXISTS scd_user_authority_tab;

CREATE TABLE IF NOT EXISTS scd_user_authority_tab (
	user_id INT NOT NULL,
	authority_id INT NOT NULL,
	CONSTRAINT fk_user_authority_user_id FOREIGN KEY (user_id) REFERENCES scd_user_profile_tab (id),
	CONSTRAINT fk_user_authority_authority_id FOREIGN KEY (authority_id) REFERENCES scd_authority_tab (id)
)
DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci
ENGINE=InnoDB
COMMENT='SCD: User Authority Mapping';

CREATE INDEX idx_user_authority_user_id ON scd_user_authority_tab (user_id, authority_id);
