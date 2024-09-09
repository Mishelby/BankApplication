CREATE
IF NOT EXISTS TABLE bank_repository.users
(
    user_id     BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(128)                            NOT NULL,
    middle_name VARCHAR(128)                            NOT NULL,
    last_name   VARCHAR(128)                            NOT NULL,
    birth_date  DATE CHECK ( birth_date < CURRENT_DATE) NOT NULL
);

CREATE
IF NOT EXISTS TABLE bank_repository.bank_account
(
    account_id BIGSERIAL PRIMARY KEY,
    balance    DECIMAL NOT NULL,
    owner_id   BIGINT REFERENCES users (user_id) ON DELETE CASCADE
);

CREATE
IF NOT EXISTS TABLE bank_repository.transactions
(
    transaction_id BIGSERIAL PRIMARY KEY,
    value          DECIMAL CHECK ( value > 0 ) NOT NULL,
    type           VARCHAR(128)                NOT NULL,
    account_id     BIGINT REFERENCES bank_account (account_id) ON DELETE CASCADE,
    category       VARCHAR(128)                NOT NULL,
    createdDate    TIMESTAMP DEFAULT now()
);