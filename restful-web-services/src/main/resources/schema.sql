 
CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `userprofile` (
  `id` bigint NOT NULL,
  `username` varchar(255) NOT NULL,
  `national_id` varchar(255) NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `banking_restriction` bit(1) DEFAULT NULL,
  `check_book_request` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


 CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint NOT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `amount` bigint NOT NULL,
  `balance` bigint NOT NULL,
  `is_credit` bit(1) DEFAULT NULL,
  `is_saving` bit(1) DEFAULT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


