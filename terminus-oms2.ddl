-- DROP SCHEMA "p2-terminus-oms2";

CREATE SCHEMA "p2-terminus-oms2" AUTHORIZATION postgres;

-- DROP SEQUENCE "p2-terminus-oms2".customers_id_seq;

CREATE SEQUENCE "p2-terminus-oms2".customers_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "p2-terminus-oms2".customers_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "p2-terminus-oms2".customers_id_seq TO postgres;

-- DROP SEQUENCE "p2-terminus-oms2".orders_id_seq;

CREATE SEQUENCE "p2-terminus-oms2".orders_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "p2-terminus-oms2".orders_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "p2-terminus-oms2".orders_id_seq TO postgres;

-- DROP SEQUENCE "p2-terminus-oms2".products_id_seq;

CREATE SEQUENCE "p2-terminus-oms2".products_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE "p2-terminus-oms2".products_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE "p2-terminus-oms2".products_id_seq TO postgres;
-- "p2-terminus-oms2".customers definition

-- Drop table

-- DROP TABLE "p2-terminus-oms2".customers;

CREATE TABLE "p2-terminus-oms2".customers (
	id serial4 NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	email varchar(30) NOT NULL,
	username varchar(15) NOT NULL,
	passwd varchar(20) NOT NULL,
	CONSTRAINT customers_pkey PRIMARY KEY (id),
	CONSTRAINT customers_username_key UNIQUE (username)
);

-- Permissions

ALTER TABLE "p2-terminus-oms2".customers OWNER TO postgres;
GRANT ALL ON TABLE "p2-terminus-oms2".customers TO postgres;


-- "p2-terminus-oms2".orders definition

-- Drop table

-- DROP TABLE "p2-terminus-oms2".orders;

CREATE TABLE "p2-terminus-oms2".orders (
	id serial4 NOT NULL,
	customer_id int4 NULL,
	order_date varchar(30) NOT NULL,
	total_price varchar(30) NOT NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id),
	CONSTRAINT orders_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES "p2-terminus-oms2".customers(id)
);

-- Permissions

ALTER TABLE "p2-terminus-oms2".orders OWNER TO postgres;
GRANT ALL ON TABLE "p2-terminus-oms2".orders TO postgres;


-- "p2-terminus-oms2".products definition

-- Drop table

-- DROP TABLE "p2-terminus-oms2".products;

CREATE TABLE "p2-terminus-oms2".products (
	id serial4 NOT NULL,
	order_id int4 NULL,
	endpoint varchar(1200) NOT NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id),
	CONSTRAINT products_order_id_fkey FOREIGN KEY (order_id) REFERENCES "p2-terminus-oms2".orders(id)
);

-- Permissions

ALTER TABLE "p2-terminus-oms2".products OWNER TO postgres;
GRANT ALL ON TABLE "p2-terminus-oms2".products TO postgres;




-- Permissions

GRANT ALL ON SCHEMA "p2-terminus-oms2" TO postgres;
