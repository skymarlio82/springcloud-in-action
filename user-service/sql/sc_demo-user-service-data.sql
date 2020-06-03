USE sc_demo_user;

-- ==============================
-- Table of scd_user_profile_tab
-- ==============================

INSERT INTO scd_user_profile_tab (username, password, enabled, lastpasswordresetdate) VALUES ('test1', MD5('password'), 1, CURRENT_TIMESTAMP);
INSERT INTO scd_user_profile_tab (username, password, enabled, lastpasswordresetdate) VALUES ('test2', MD5('password'), 1, CURRENT_TIMESTAMP);

-- ===========================
-- Table of scd_authority_tab
-- ===========================

INSERT INTO scd_authority_tab (name) VALUES ('ROLE_ADMIN');
INSERT INTO scd_authority_tab (name) VALUES ('ROLE_USER');

-- ================================
-- Table of scd_user_authority_tab
-- ================================

INSERT INTO scd_user_authority_tab (user_id, authority_id) VALUES (1, 1);
INSERT INTO scd_user_authority_tab (user_id, authority_id) VALUES (1, 2);
INSERT INTO scd_user_authority_tab (user_id, authority_id) VALUES (2, 2);
