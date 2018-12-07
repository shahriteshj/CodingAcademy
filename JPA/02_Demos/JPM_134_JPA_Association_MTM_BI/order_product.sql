CREATE TABLE order_mtm(
order_id NUMBER(6) PRIMARY KEY,
order_date DATE);		

CREATE TABLE product_mtm(
		product_id NUMBER(6) PRIMARY KEY,
		 NAME VARCHAR2(50),
		 PRICE NUMBER);
		 
CREATE TABLE product_orders_mtm
(order_id NUMBER(6) REFERENCES order_mtm(order_id),
product_id NUMBER(6) REFERENCES product_mtm(product_id),
PRIMARY KEY(order_id,product_id));

select * from order_mtm;
select * from product_mtm;
select * from product_orders_mtm;
drop TABLE product_orders_mtm;
drop TABLE order_mtm;
drop TABLE product_mtm;
