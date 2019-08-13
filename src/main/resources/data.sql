-- --------------- --
-- AUTOMATION TYPE --
-- --------------- --
INSERT INTO automation_type (`id`,`name`,`description`) VALUES (100,'first-automation-type','First Automation Type');
INSERT INTO automation_type (`id`,`name`,`description`) VALUES (101,'second-automation-type','Second Automation Type');

-- ------- --
-- CHAPTER --
-- ------- --
INSERT INTO chapter (`id`,`automation_id`, `name`, `automation_name`,`description`, `general_info`, `created_at`, `created_by`)
VALUES (100, 100, 'test-chapter-name-0','automation-test-name', 'test-description-0', 'test-general-info','2019-08-03 19:53:56', 'FirstTestDandelion');
INSERT INTO chapter (`id`,`automation_id`, `name`, `automation_name`,`description`, `general_info`, `created_at`, `created_by`)
VALUES (101, 101, 'test-chapter-name-0','automation-test-name', 'test-description-1', 'test-general-info','2019-08-03 19:53:56', 'SecondTestDandelion');

-- --------------- ---
-- CHAPTER SELF-CHECK QUESTION --
-- ---------------- --
INSERT INTO `self_check_question` (`id`,`chapter_id`,`chapter_name`, `question`, `answer`,`created_at`, `created_by`)
VALUES (100, 100, 'test-chapter-name-0', 'Test-self-check-question-0', 'Test-self-check-answer-0', '2019-08-03 19:53:56', 'FirstTestDandelion');
INSERT INTO `self_check_question` (`id`,`chapter_id`,`chapter_name`, `question`, `answer`,`created_at`, `created_by`)
VALUES (101, 101, 'test-chapter-name-0', 'Test-self-check-question-1', 'Test-self-check-answer-1', '2019-08-03 19:53:56', 'FirstTestDandelion');

-- ---------- --
-- VOCABULARY --
-- ---------- --
INSERT INTO vocabulary (`id`,`key_word`,`value`,`created_at`,`created_by`) VALUES (100,'FirstTestKeyword', 'FirstTestValue','2019-08-03 19:53:56','FirstTestDandelion');
INSERT INTO vocabulary (`id`,`key_word`,`value`,`created_at`,`created_by`) VALUES (101,'SecondTestKeyword', 'SecondTestValue','2019-08-03 19:53:56','SecondTestDandelion');

