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
INSERT INTO `self_check_question` (`id`,`chapter_id`,`chapter_name`, `question`, `answer`,`created_at`,`created_by`)
VALUES (100, 100, 'test-chapter-name-0', 'Test-self-check-question-0', 'Test-self-check-answer-0', '2019-08-03 19:53:56', 'FirstTestDandelion');
INSERT INTO `self_check_question` (`id`,`chapter_id`,`chapter_name`, `question`, `answer`,`created_at`, `created_by`)
VALUES (101, 101, 'test-chapter-name-0', 'Test-self-check-question-1', 'Test-self-check-answer-1', '2019-08-03 19:53:56', 'FirstTestDandelion');

-- ---------------- --
-- AUTOMATION TOPIC --
-- ---------------- --
INSERT INTO automation_topic (`id`,`name`, `description`) VALUES (100,'test-automation-topic-name-0', 'Test Automation Topic Description 0');
INSERT INTO automation_topic (`id`,`name`, `description`) VALUES (101,'test-automation-topic-name-1', 'Test Automation Topic Description 1');

-- ----------------------- ---
-- AUTOMATION TOPIC CHAPTER --
-- ------------------------ --
INSERT INTO `automation_topic_chapter` (`id`,`automation_topic_id`, `automation_topic_name`, `name`, `description`, `key_word`, `begin_with`, `text`,`created_at`,`created_by`)
VALUES (100,(SELECT id FROM automation_topic WHERE name LIKE 'test-automation-topic-name-0' limit 1), 'test-automation-topic-name-0','test-automation-topic-chapter-name-0',
 'test-automation-topic-chapter-description-0', 'test-key-word-0', 'test-begin-with-0','test-text-0','2019-08-03 19:53:56','dandelion');
INSERT INTO `automation_topic_chapter` (`id`,`automation_topic_id`, `automation_topic_name`, `name`, `description`, `key_word`, `begin_with`, `text`,`created_at`,`created_by`)
VALUES (101,(SELECT id FROM automation_topic WHERE name LIKE 'test-automation-topic-name-0' limit 1), 'test-automation-topic-name-0','test-automation-topic-chapter-name-1',
 'test-automation-topic-chapter-description-1', 'test-key-word-1', 'test-begin-with-1','test-text-1','2019-08-03 19:53:56','dandelion');
INSERT INTO `automation_topic_chapter` (`id`,`automation_topic_id`, `automation_topic_name`, `name`, `description`, `key_word`, `begin_with`, `text`,`created_at`,`created_by`)
VALUES (102,(SELECT id FROM automation_topic WHERE name LIKE 'test-automation-topic-name-1' limit 1), 'test-automation-topic-name-1','test-automation-topic-chapter-name-2',
 'test-automation-topic-chapter-description-2', 'test-key-word-2', 'test-begin-with-2','test-text-2','2019-08-03 19:53:56','dandelion');

-- ---------- --
-- VOCABULARY --
-- ---------- --
INSERT INTO vocabulary (`id`,`key_word`,`value`,`created_at`,`created_by`) VALUES (100,'FirstTestKeyword', 'FirstTestValue','2019-08-03 19:53:56','FirstTestDandelion');
INSERT INTO vocabulary (`id`,`key_word`,`value`,`created_at`,`created_by`) VALUES (101,'SecondTestKeyword', 'SecondTestValue','2019-08-03 19:53:56','SecondTestDandelion');

