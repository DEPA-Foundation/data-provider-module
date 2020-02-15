CREATE TYPE "link_status" AS ENUM (
  'DISCOVERED',
  'DELINKED',
  'LINKED'
);

CREATE TYPE "account_type" AS ENUM (
  'SAVINGS',
  'CHECKING'
);

CREATE TYPE "consent_status" AS ENUM (
  'CREATED',
  'REVOKED',
  'PAUSED',
  'RESUMED',
  'EXPIRED'
);

CREATE TYPE "fetch_type" AS ENUM (
  'ONE_TIME',
  'RECURRING'
);

CREATE TYPE "mode" AS ENUM (
  'VIEW',
  'EDIT'
);

CREATE TABLE "accounts" (
  "id" int PRIMARY KEY,
  "aa_id" varchar,
  "link_ref_number" varchar,
  "customer_aa_id" varchar,
  "account_number" varchar,
  "account_ref_number" varchar,
  "account_type" account_type,
  "status" link_status,
  "timestamp" timestamp
);

CREATE TABLE "consents" (
  "id" SERIAL PRIMARY KEY,
  "account_id" int,
  "last_access_timestamp" timestamp,
  "start_timestamp" timestamp,
  "end_timestamp" timestamp,
  "status" consent_status,
  "fetch_type" fetch_type,
  "types" varchar,
  "fi_types" varchar,
  "data_start_timestamp" timestamp,
  "data_end_timestamp" timestamp,
  "mode" mode,
  "frequency" int,
  "data_filter_type" varchar,
  "data_filter_operator" varchar,
  "data_filter_value" float
);

ALTER TABLE "consents" ADD FOREIGN KEY ("account_id") REFERENCES "accounts" ("id");

CREATE UNIQUE INDEX "accounts_link_ref_number_idx" ON "accounts" ("link_ref_number");

CREATE INDEX "accounts_cust_aa_id_account_number_idx" ON "accounts" ("customer_aa_id", "account_number");

CREATE INDEX "consents_account_id_idx" ON "consents" ("account_id");
