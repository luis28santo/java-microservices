CREATE TABLE patient (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    status SMALLINT NOT NULL DEFAULT 1
);
