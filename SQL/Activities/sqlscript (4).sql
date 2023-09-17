REM   Script: Activity6
REM   Activity6 of SQL

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

