create table category(
id identity,
name varchar(50),
description varchar(255),
image_url varchar(50),
is_active boolean,

constraint pk_category_id primary key (id)
);

insert into category (name,description,image_url,is_active) values('Television','This is some description for television','CAT_1.png',true),('Laptop','This is some description for laptop','CAT_2.png',true),('Mobile','This is some description for mobile','CAT_3.png',true);

create table user_detail(
  id identity,
  first_name varchar(50),
  last_name varchar(50),
  role varchar(50),
  enabled boolean,
  password varchar(50),
  email varchar(100),
  contact_number varchar(15),
  constraint pk_user_id primary key(id)
);

insert into user_detail (first_name,last_name,role,enabled,password,email,contact_number) values('Virat','Kohli','ADMIN',true,'admin','vk@gmail.com','8888888888'),('Ravindra','nath','SUPPLIER',true,'12345','rj@gmail.com','9999999999'),('Namal','Shantha','SUPPLIER',true,'12345','ns@gmail.com','7777777777');

create table product(
  id identity,
  code varchar(20),
  name varchar(50),
  brand varchar(50),
  description varchar(255),
  unit_price decimal(10,2),
  quantity int,
  is_active boolean,
  category_id int,
  supplier_id int,
  purchases int default 0,
  views int default 0,
  constraint pk_product_id primary key(id),
  constraint fk_category_id foreign key(category_id) references category(id),
  constraint fk_supplier_id foreign key(supplier_id) references user_detail(id)
);

insert into product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)
values('PRDABC123DEFX','iphone 5s','apple','This is one of the best android phone available in the market right now!',125000,5,true,3,1,3,2),
('PRDDEF123DEFX','Samsung s7','samsung','A smart phone by samsung!',57000,5,true,3,2,5,3),
('PRDPQR123DWGX','Google pixel','google','This is one of the best android phone available in the market right now!',60000,5,true,3,2,2,2),
('PRDMNO123DEFX','Mackbook pro','apple','This is one of the best laptop available in the market right now!',157000,5,true,2,1,1,2),
('PRDABC123DXXX','Del Latitude E6510','dell','This is one of the best laptop series from dell that can used!',48000,5,true,2,2,1,3),
('PRD3707BEDE5B','Oppo Selfie S53','oppo','A smart phone by oppo!',25000,0,true,3,2,5,3)
('PRDA6953C84AD','MacBook Pro 13','apple','This is one of the best laptop series from apple that can used!',111000,5,true,2,2,1,3);