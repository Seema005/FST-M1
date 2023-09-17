REM   Script: Activity9
REM   Activity9
 of SQL

CREATE TABLE salesman ( 
    salesman_id INT, 
    salesman_name VARCHAR2(20), 
    salesman_city VARCHAR2(20), 
    commission INT 
);

DESCRIBE salesman


INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES 
    (5001, 'James Hoog', 'New York', 15), 
    (5002, 'Nail Knite', 'Paris', 13), 
    (5005, 'Pit Alex', 'London', 11), 
    (5006, 'McLyon', 'Paris', 14), 
    (5007, 'Paul Adam', 'Rome', 13), 
    (5003, 'Lauson Hen', 'San Jose', 12);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES 
(5001, 'James Hoog', 'New York', 15), 
(5002, 'Nail Knite', 'Paris', 13), 
(5005, 'Pit Alex', 'London', 11), 
(5006, 'McLyon', 'Paris', 14), 
(5007, 'Paul Adam', 'Rome', 13), 
(5003, 'Lauson Hen', 'San Jose', 12);

INSERT ALL INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES 
(5001, 'James Hoog', 'New York', 15), 
(5002, 'Nail Knite', 'Paris', 13), 
(5005, 'Pit Alex', 'London', 11), 
(5006, 'McLyon', 'Paris', 14), 
(5007, 'Paul Adam', 'Rome', 13), 
(5003, 'Lauson Hen', 'San Jose', 12);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city 
FROM salesman;

SELECT salesman_id, salesman_city 
FROM salesman;

SELECT * 
FROM salesman 
WHERE salesman_city = 'Paris';

SELECT salesman_id, commission 
FROM salesman 
WHERE salesman_name = 'Paul Adam';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT DISTINCT salesman_id 
FROM orders;

SELECT order_no 
FROM orders 
ORDER BY order_date ASC;

SELECT order_no 
FROM orders 
ORDER BY purchase_amount DESC;

SELECT * 
FROM orders 
WHERE purchase_amount < 500;

SELECT * 
FROM orders 
WHERE purchase_amount BETWEEN 1000 AND 2000;

SELECT SUM(purchase_amount) AS total_purchase_amount 
FROM orders;

SELECT AVG(purchase_amount) AS average_purchase_amount 
FROM orders;

SELECT MAX(purchase_amount) AS max_purchase_amount 
FROM orders;

SELECT MIN(purchase_amount) AS min_purchase_amount 
FROM orders;

SELECT COUNT(DISTINCT salesman_id) AS number_of_salesmen 
FROM orders;

SELECT customer_id, MAX(purchase_amount) AS highest_purchase_amount 
FROM orders 
GROUP BY customer_id;

SELECT salesman_id, MAX(purchase_amount) AS highest_purchase_amount 
FROM orders 
WHERE order_date = TO_DATE('2012-08-17', 'YYYY-MM-DD') 
GROUP BY salesman_id;

SELECT customer_id, order_date, MAX(purchase_amount) AS highest_purchase_amount 
FROM orders 
WHERE purchase_amount IN (2030, 3450, 5760, 6000) 
GROUP BY customer_id, order_date;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT c.customer_name AS Customer, s.salesman_name AS Salesman 
FROM customers c 
INNER JOIN salesman s ON c.salesman_id = s.salesman_id;

SELECT c.customer_name AS Customer, c.grade 
FROM customers c 
WHERE c.grade < 300 AND c.salesman_id IS NOT NULL 
ORDER BY c.grade ASC;

SELECT c.customer_name AS Customer, s.salesman_name AS Salesman, o.commission 
FROM customers c 
INNER JOIN salesman s ON c.salesman_id = s.salesman_id 
INNER JOIN orders o ON c.customer_id = o.customer_id 
WHERE o.commission > 12;

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name AS Customer, s.salesman_name AS Salesman, o.commission 
FROM orders o 
INNER JOIN customers c ON o.customer_id = c.customer_id 
INNER JOIN salesman s ON c.salesman_id = s.salesman_id;

