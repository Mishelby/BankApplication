
CREATE SCHEMA IF NOT EXISTS bank_repository;

CREATE TABLE IF NOT EXISTS bank_repository.users
(
    user_id     BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(128)                            NOT NULL,
    middle_name VARCHAR(128)                            NOT NULL,
    last_name   VARCHAR(128)                            NOT NULL,
    birth_date  DATE CHECK ( birth_date < CURRENT_DATE) NOT NULL
);

CREATE TABLE IF NOT EXISTS bank_repository.bank_account
(
    account_id BIGSERIAL PRIMARY KEY,
    balance    DECIMAL NOT NULL,
    owner_id   BIGINT REFERENCES bank_repository.users (user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS bank_repository.transactions
(
    transaction_id BIGSERIAL PRIMARY KEY,
    value          DECIMAL CHECK ( value > 0 ) NOT NULL,
    type           VARCHAR(128)                NOT NULL,
    account_id     BIGINT REFERENCES bank_repository.bank_account (account_id) ON DELETE CASCADE,
    category       VARCHAR(128)                NOT NULL,
    created_date    TIMESTAMP DEFAULT now()
);
