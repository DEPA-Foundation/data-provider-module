-- enables the extension that allows the usage of UUID functions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE "account_link_status" AS ENUM (
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

CREATE TYPE "consent_fetch_type" AS ENUM (
  'ONE_TIME',
  'RECURRING'
);

CREATE TYPE "consent_mode" AS ENUM (
  'VIEW',
  'EDIT'
);

CREATE TABLE "accounts" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "aa_id" CHARACTER VARYING,
  "link_ref_number" CHARACTER VARYING,
  "customer_aa_id" CHARACTER VARYING,
  "account_number" CHARACTER VARYING,
  "account_ref_number" CHARACTER VARYING,
  "type" account_type,
  "status" account_link_status,
  "created_at" timestamp DEFAULT current_timestamp,
  "updated_at" timestamp DEFAULT current_timestamp
);

CREATE TABLE "consents" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "account_id" uuid,
  "status" consent_status,
  "fetch_type" consent_fetch_type,
  "types" CHARACTER VARYING,
  "fi_types" CHARACTER VARYING,
  "mode" consent_mode,
  "frequency" int,
  "data_filter_type" CHARACTER VARYING,
  "data_filter_operator" CHARACTER VARYING,
  "data_filter_value" float,
  "last_access_timestamp" timestamp,
  "start_timestamp" timestamp,
  "end_timestamp" timestamp,
  "data_start_timestamp" timestamp,
  "data_end_timestamp" timestamp,
  "created_at" timestamp DEFAULT current_timestamp,
  "updated_at" timestamp DEFAULT current_timestamp
);

ALTER TABLE "consents" ADD FOREIGN KEY ("account_id") REFERENCES "accounts" ("id");

CREATE UNIQUE INDEX "accounts_link_ref_number_idx" ON "accounts" ("link_ref_number");

CREATE INDEX "accounts_cust_aa_id_account_number_idx" ON "accounts" ("customer_aa_id", "account_number");

CREATE INDEX "consents_account_id_idx" ON "consents" ("account_id");