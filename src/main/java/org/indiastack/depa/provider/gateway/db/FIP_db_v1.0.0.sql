CREATE TABLE `accounts` (
  `id` int PRIMARY KEY,
  `ref_number` varchar(255),
  `cust_aa_id` varchar(255),
  `account_number` varchar(255),
  `account_ref_number` varchar(255),
  `account_type` ENUM ('SAVINGS', 'CHECKING'),
  `link_status` varchar(255),
  `timestamp` timestamp
);

CREATE TABLE `consent_metadata` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `cust_aa_id` varchar(255),
  `account_id` int,
  `last_access_timestamp` timestamp,
  `start_timestamp` timestamp,
  `end_timestamp` timestamp,
  `consent_status` varchar(255),
  `fetch_type` varchar(255),
  `consent_types` varchar(255),
  `fi_types` varchar(255),
  `data_start_timestamp` timestamp,
  `data_end_timestamp` timestamp,
  `mode` varchar(255),
  `frequency` int,
  `data_filter_type` varchar(255),
  `data_filter_operator` varchar(255),
  `data_filter_value` float
);

ALTER TABLE `consent_metadata` ADD FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`);

CREATE UNIQUE INDEX `accounts_index_0` ON `accounts` (`ref_number`);

CREATE INDEX `accounts_index_1` ON `accounts` (`cust_aa_id`, `account_number`);

CREATE INDEX `consent_metadata_index_2` ON `consent_metadata` (`account_id`);
