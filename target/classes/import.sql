DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Orange', 200), ('Apple', 99), ('Tomato', 77), ('Carrot', 30);
