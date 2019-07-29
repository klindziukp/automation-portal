CREATE DATABASE automation;

CREATE TABLE IF NOT EXISTS `automation_type` (
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT uc_name UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `chapter` (
	`id` BIGINT AUTO_INCREMENT,
	`automation_id` BIGINT,
    `automation_name` VARCHAR(255),
	`name` VARCHAR(255),
	`description` VARCHAR(255),
	`general_info` VARCHAR(255),
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`),
	CONSTRAINT uc_name UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `question` (
	`id` BIGINT AUTO_INCREMENT,
	`chapter_id` BIGINT,
    `chapter_name` VARCHAR(255),
	`text` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `note` (
	`id` BIGINT AUTO_INCREMENT,
    `chapter_id` BIGINT,
    `chapter_name` VARCHAR(255),
	`text` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `task` (
	`id` BIGINT AUTO_INCREMENT,
	`chapter_id` BIGINT,
    `chapter_name` VARCHAR(255),
	`text` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `link` (
	`id` BIGINT AUTO_INCREMENT,
	`chapter_id` BIGINT,
    `chapter_name` VARCHAR(255),
	`text` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `self_check_question` (
	`id` BIGINT AUTO_INCREMENT,
	`chapter_id` BIGINT,
    `chapter_name` VARCHAR(255),
	`question` LONGTEXT,
	`answer` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `automation_topic` (
	`id` BIGINT AUTO_INCREMENT,
	`name` VARCHAR(255),
	`description` VARCHAR(255),
	PRIMARY KEY (`id`),
	CONSTRAINT uc_name UNIQUE (name)
);

CREATE TABLE `vocabulary` (
	`id` BIGINT AUTO_INCREMENT,
	`key` VARCHAR(255),
	`value` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `automation_topic_chapter` (
	`id` BIGINT AUTO_INCREMENT,
	`automation_topic_id` BIGINT,
  	`automation_topic_name` VARCHAR(255),
    `name` VARCHAR(255),
    `description` VARCHAR(255),
    `key` VARCHAR(255),
	`begin_with` VARCHAR(255),
	`text` LONGTEXT,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	`deleted_at` TIMESTAMP NULL DEFAULT NULL,
	`created_by` VARCHAR(255),
	`updated_by` VARCHAR(255),
	`deleted_by` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `chapter` ADD CONSTRAINT `chapter_fk0` FOREIGN KEY (`automation_id`) REFERENCES `automation_type`(`id`) ON DELETE CASCADE;

ALTER TABLE `question` ADD CONSTRAINT `question_fk0` FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`id`) ON DELETE CASCADE;

ALTER TABLE `note` ADD CONSTRAINT `note_fk0` FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`id`) ON DELETE CASCADE;

ALTER TABLE `task` ADD CONSTRAINT `task_fk0` FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`id`) ON DELETE CASCADE;

ALTER TABLE `link` ADD CONSTRAINT `link_fk0` FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`id`) ON DELETE CASCADE;

ALTER TABLE `self_check_question` ADD CONSTRAINT `self_check_question_fk0` FOREIGN KEY (`chapter_id`) REFERENCES `chapter`(`id`) ON DELETE CASCADE;

ALTER TABLE `automation_topic_chapter` ADD CONSTRAINT `automation_topic_chapter_fk0` FOREIGN KEY (`automation_topic_id`) REFERENCES `automation_topic`(`id`) ON DELETE CASCADE;

