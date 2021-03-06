INSERT INTO products(product_id, name, price, type) VALUES
(1, 'Butter', 2.55, 'FOOD'),
(2, 'Bread', 5.50, 'FOOD'),
(3, 'Turkey', 13.00, 'FOOD'),
(4, 'Salmon', 9.99, 'FOOD'),
(5, 'Milk', 2.00, 'FOOD'),
(6, 'iPhone', 4000, 'ELECTRONICS'),
(7, 'DVD Player', 1800, 'ELECTRONICS'),
(8, 'Printer', 600, 'ELECTRONICS'),
(9, 'TV', 3500, 'ELECTRONICS'),
(10, 'MP3 player', 70, 'ELECTRONICS'),
(11, 'Artificial plant', 10, 'HOME'),
(12, 'Mirror', 8, 'HOME'),
(13, 'Clock', 20, 'HOME'),
(14, 'Pillow', 12, 'HOME'),
(15, 'Candle', 5, 'BEAUTY'),
(16, 'Shampoo', 9, 'BEAUTY'),
(17, 'Moisturizer', 13, 'BEAUTY'),
(18, 'Facial cream', 7, 'BEAUTY'),
(19, 'Sunscreen', 15, 'BEAUTY'),
(20, 'Body luminizer', 20, 'BEAUTY');

INSERT INTO addresses(address_id, country, city, postal, street, number) VALUES
(1, 'Polska', 'Warszawa', '01-201', 'Wolska', '135A'),
(2, 'Polska', 'Poznań', '61-080', 'Miejska', '14/2');

INSERT INTO roles(role_id, username, role) VALUES
(1, 'Jan', 'ROLE_USER'),
(2, 'Piotr', 'ROLE_ADMIN');

INSERT INTO users(user_id, username, first_name, last_name, email, password, active, address_id, role_id) VALUES
(1, 'Jan', 'Janusz', 'Kowalski', 'jankowalski@example.pl', '{bcrypt}$2a$10$0hL5wG5oL7xswitkkwboeejVqLVl9RzVBayU/yqwIDaJ8MhuLs/Cy', true, 1, 1),
(2, 'Piotr', 'Piotr', 'Mazurek', 'piotrmazurek@example.pl', '{bcrypt}$2a$10$0hL5wG5oL7xswitkkwboeejVqLVl9RzVBayU/yqwIDaJ8MhuLs/Cy', true, 2, 2);