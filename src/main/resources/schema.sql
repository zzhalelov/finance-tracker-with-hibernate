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