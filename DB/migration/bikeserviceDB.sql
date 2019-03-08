CREATE TABLE service
(
id NUMBER(10) CONSTRAINT pk_service_id primary key,
customer_name VARCHAR2(50) not null,
phone NUMBER(10) CONSTRAINT chk_phone CHECK (phone not like '%[^0-9]%'),
address VARCHAR2(100) not null,
company VARCHAR2(15) not null,
bike_name VARCHAR2(15) not null,
bike_model VARCHAR2(15),
bike_number VARCHAR2(15) not null,
customer_issue int not null,
expected_date date);




create SEQUENCE service_id_seq
START WITH 1
INCREMENT BY 1;

select * from service;



Create table worker(id NUMBER(10) CONSTRAINT pk_worker_id primary key,
name VARCHAR2(50)not null,
phone NUMBER(10)not null
address VARCHAR2(100)not null);


create SEQUENCE worker_id_seq
START WITH 1
INCREMENT BY 1;

select * from worker;


Create table service_type(id NUMBER(10) CONSTRAINT pk_type_id primary key,name VARCHAR2(90) not null,days NUMBER(3) not null);

alter table service modify customer_issue CONSTRAINT pk_cust_id references service_type(id);

create SEQUENCE type_id_seq
START WITH 1
INCREMENT BY 1;

Create table admin(phone NUMBER(10)  CONSTRAINT chk_admin_phone CHECK (phone not like '%[^0-9]%',password VARCHAR2(20) not null);
insert into admin(phone,password) VALUES(9942021073,2698);
commit;

create table slot(id NUMBER(10) not null,count int not null,up_date date not null); 
