-- enables the extension that allows the usage of UUID functions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "accounts" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "aa_id" CHARACTER VARYING,
  "customer_aa_id" CHARACTER VARYING,
  "number" CHARACTER VARYING,
  "bank_ref_number" CHARACTER VARYING,
  "type" CHARACTER VARYING,
  "status" CHARACTER VARYING,
  "created_at" timestamp DEFAULT current_timestamp,
  "updated_at" timestamp DEFAULT current_timestamp
);

CREATE TABLE "consents" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "account_id" uuid,
  "status" CHARACTER VARYING,
  "fetch_type" CHARACTER VARYING,
  "type" CHARACTER VARYING,
  "mode" CHARACTER VARYING,
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

CREATE INDEX "accounts_cust_aa_id_account_number_idx" ON "accounts" ("customer_aa_id", "number");

CREATE INDEX "consents_account_id_idx" ON "consents" ("account_id");