-- Insert sin especificar estado (toma default = 1)
INSERT INTO patient (first_name, last_name, birth_date, email)
VALUES ('Luis', 'Santos Medina', '2000-03-28', 'luis.santos@example.com');

INSERT INTO patient (first_name, last_name, birth_date, email, status)
VALUES ('Lucía', 'Ramírez', '1988-07-22', 'lucia.ramirez@example.com', 1);

-- Insert con estado = 0 (inactivo)
INSERT INTO patient (first_name, last_name, birth_date, email, status)
VALUES ('Pedro', 'López', '1995-10-10', 'pedro.lopez@example.com', 0);

INSERT INTO patient (first_name, last_name, birth_date, email, status)
VALUES ('Jorge', 'Fernández', '1985-01-05', 'jorge.fernandez@example.com', 0);
