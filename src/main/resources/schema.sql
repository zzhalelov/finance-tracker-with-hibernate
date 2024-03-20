--таблица с категориями доходов
CREATE TABLE income_categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(15)
);

--Таблица с категориями расходов
CREATE TABLE expense_categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(25)
);

--счета для списание денег
CREATE TABLE accounts
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR
);

--таблица, хранящая в себе записи о расходах
CREATE TABLE expenses
(
    id                  SERIAL,
    date                DATE,
    amount              DOUBLE PRECISION,
    expense_category_id INT REFERENCES expense_categories (id),
    account_id          INT REFERENCES accounts (id),
    comment             TEXT
);

--таблица, хранящая в себе записи о доходах
CREATE TABLE incomes
(
    id                 SERIAL,
    date               DATE,
    amount             DOUBLE PRECISION,
    income_category_id INT REFERENCES income_categories (id),
    account_id         INT REFERENCES accounts (id),
    comment            TEXT
);

--таблица, хранящая в себе записи о переводах между счетами
CREATE TABLE transfers
(
    id                     SERIAL,
    date                   DATE,
    amount                 DOUBLE PRECISION,
    fee                    DOUBLE PRECISION,
    source_account_id      INT REFERENCES accounts (id),
    destination_account_id INT REFERENCES accounts (id),
    comment                TEXT
);