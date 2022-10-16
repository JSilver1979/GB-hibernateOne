DROP TABLE shop_history IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE clients IF EXISTS;

CREATE TABLE IF NOT EXISTS products (product_id bigserial, price int, title VARCHAR(255), PRIMARY KEY (product_id));
INSERT INTO products (title, price) VALUES ('Black Sails', 1000), ('Big Guns', 5000), ('Rom Barrel', 300), ('CannonBall', 10);
CREATE TABLE IF NOT EXISTS clients (client_id bigserial, client_name VARCHAR(255), PRIMARY KEY (client_id));
INSERT INTO clients (client_name) VALUES ('Jack Sparrow'), ('Barbossa'), ('Deby Jones');
CREATE TABLE IF NOT EXISTS shop_history (client_id bigint REFERENCES clients(client_id), product_id bigint REFERENCES products(product_id));
INSERT INTO shop_history (client_id, product_id) VALUES (1,1), (1,3), (2,1), (2,2), (2,3), (2,4), (3,1);

