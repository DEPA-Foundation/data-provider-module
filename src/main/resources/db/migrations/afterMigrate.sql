-- Stored Procedure that updates the `updated_at` column

CREATE OR REPLACE FUNCTION update_updated_at() RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at = current_timestamp;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


DO
$$
    DECLARE
        t text;
    BEGIN
        FOR t IN
            SELECT table_name
            FROM information_schema.tables
            WHERE table_schema = 'depa'
                AND table_name NOT LIKE '%schema_history'
            LOOP
                -- Add `updated_at` column if missing
                EXECUTE format('ALTER TABLE %s
                                ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP DEFAULT to_timestamp(0);', t);

                -- For re-assurance, if `updated_at` column already exists, updates the default value
                EXECUTE format('ALTER TABLE %s
                                ALTER COLUMN updated_at SET DEFAULT current_timestamp;', t);

                -- For re-assurance, drops the trigger and re-creates. Ensures any modifications to the triggers are
                -- propagated
                EXECUTE format('DROP TRIGGER IF EXISTS update_updated_at ON %s', t);

                -- Sets up the created_at pre-save triggers
                EXECUTE format('CREATE TRIGGER update_updated_at
                        BEFORE UPDATE ON %I
                        FOR EACH ROW EXECUTE PROCEDURE update_updated_at()', t);

            END LOOP;
    END
$$ LANGUAGE plpgsql;