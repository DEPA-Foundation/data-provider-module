CREATE TABLE `accounts` (
  `id` int PRIMARY KEY,
  `linkRefNumber` varchar(255),
  `cust_aa_id` varchar(255),
  `account_number` varchar(255),
  `account_ref_number` varchar(255),
  `account_type` ENUM ('SAVINGS', 'CHECKING'),
  `status` ENUM ('DISCOVERED', 'DELINKED', 'LINKED'),
  `timestamp` timestamp
);

CREATE TABLE `consents` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `cust_aa_id` varchar(255),
  `account_id` int,
  `last_access_timestamp` timestamp,
  `start_timestamp` timestamp,
  `end_timestamp` timestamp,
  `status` ENUM ('CREATED', 'REVOKED', 'PAUSED', 'RESUMED', 'EXPIRED'),
  `fetch_type` ENUM ('ONE_TIME', 'RECURRING'),
  `types` varchar(255),
  `fi_types` varchar(255),
  `data_start_timestamp` timestamp,
  `data_end_timestamp` timestamp,
  `mode` ENUM ('VIEW', 'EDIT'),
  `frequency` int,
  `data_filter_type` varchar(255),
  `data_filter_operator` varchar(255),
  `data_filter_value` float
);

ALTER TABLE `consents` ADD FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`);

CREATE UNIQUE INDEX `accounts_index_0` ON `accounts` (`linkRefNumber`);

CREATE INDEX `accounts_cust_aa_id_account_number_idx` ON `accounts` (`cust_aa_id`, `account_number`);

CREATE INDEX `consents_account_id_idx` ON `consents` (`account_id`);
