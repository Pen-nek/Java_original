create table product(
p_id VARCHAR2(20) not null,
p_name VARCHAR2(20),
p_unitPrice INT,
p_description VARCHAR2(1000),
p_category VARCHAR2(20),
p_publisher VARCHAR2(20),
p_unitsInStock INT,
p_condition VARCHAR2(20),
p_fileName VARCHAR2(20),
PRIMARY KEY(p_id));

commit;

DROP TABLE product;

INSERT INTO product VALUES('P1234', 'iPhone 6s', 800000, '1334X750 Renina HD display, 8-megapixel iSight Camera','Smart Phone', 'Apple', 1000, 'new', 'P1234.png');
INSERT INTO product VALUES('P1235', 'LG PC gram', 1500000, '3.3-inch,IPS LED display, 5rd Generation Intel Core processors', 'Notebook', 'LG', 1000, 'new', 'P1235.png');
INSERT INTO product VALUES('P1236', 'Galaxy Tab S', 900000, '3.3-inch, 212.8*125.6*6.6mm,  Super AMOLED display, Octa-Core processor', 'Tablet', 'Samsung', 1000, 'new', 'P1236.png');

commit;

select * from product;