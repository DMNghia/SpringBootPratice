drop schema if exists `phonecardmarket`;
create schema `phonecardmarket`;
use `phonecardmarket`;
ALTER DATABASE `phonecardmarket` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

drop table if exists `role`;
create table role(
    id smallint,
    name varchar(255),
    primary key (id)
);

insert into role (id, name)
values (1, 'ADMIN'),
       (2, 'USER');

DROP TABLE IF EXISTS `user`;
create table user
(
    id          int          not null AUTO_INCREMENT,
    username     varchar(255) COLLATE utf8_bin,
    password    varchar(255) not null COLLATE utf8_bin,
    email       varchar(255) not null,
    role        smallint,
    phone varchar(255),
    balance     double,
    is_delete    boolean,
    is_active    boolean,
    created_at   datetime,
    updated_at   datetime,
    avatar varchar(255),
    primary key (id)
);
insert into user(id, username, password, email, role, phone, balance, stage, created_at)
values (1, 'sys_admin', '$2a$10$nhiHq84t7pZdKwUtdmtdBeuqp7umulVWARoZ7MmHwk7.TXJyykJB.', 'minhnghia15112002@gmail.com', 1, '0344389201', 1000000000, 'ACTIVED', '2023-07-30 12:14:32'),
       (2, 'nghia', '$2a$10$nhiHq84t7pZdKwUtdmtdBeuqp7umulVWARoZ7MmHwk7.TXJyykJB.', 'dmnghia1511@gmail.com', 2, '0344389201', 10000000, 'ACTIVED', '2023-07-30 12:14:32');

drop table if exists `authentication_token`;
create table authentication_token(
    id bigint not null auto_increment,
    token varchar(255) not null ,
    expired_at datetime not null ,
    created_at datetime,
    user int,
    is_delete boolean,
    primary key (id, token)
);

DROP TABLE IF EXISTS `supplier`;
create table supplier
(
    id        int not null AUTO_INCREMENT,
    name      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null,
    image varchar(255),
    created_at datetime,
    created_by int,
    is_delete  boolean,
    updated_at datetime,
    updated_by int,
    primary key (id)
);
insert into supplier(id, name, image, created_at, created_by, is_delete)
values (1, 'Viettel', '/assets/images/viettel.png', '2023-07-30 12:14:32', 1, false),
       (2, 'Vinaphone', '/assets/images/vinaphone.png', '2023-07-30 12:14:32', 1, false),
       (3, 'Vietnamemobile', '/assets/images/vietnamemobile.png', '2023-07-30 12:14:32', 1, false),
       (4, 'Mobifone', '/assets/images/mobifone.png', '2023-07-30 12:14:32', 1, false);

DROP TABLE IF EXISTS `product`;
create table product
(
    id        int not null AUTO_INCREMENT,
    name      varchar(255) not null,
    quantity  int,
    price     double,
    supplier  int,
    created_at datetime,
    created_by int,
    is_delete  boolean,
    updated_at datetime,
    updated_by int,
    primary key (id)
);
insert into product (`name`, quantity, price, supplier, created_at, created_by, is_delete)
values
    ('Thẻ Viettel 10.000', 50, 10000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 20.000', 50, 20000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 30.000', 50, 30000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 50.000', 50, 50000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 100.000', 50, 100000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 200.000', 50, 200000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 300.000', 50, 300000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Viettel 500.000', 50, 500000, 1, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 10.000', 50, 10000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 20.000', 50, 20000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 30.000', 50, 30000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 50.000', 50, 50000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 100.000', 50, 100000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 200.000', 50, 200000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 300.000', 50, 300000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vinaphone 500.000', 50, 500000, 2, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 10.000', 50, 10000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 20.000', 50, 20000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 30.000', 50, 30000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 50.000', 50, 50000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 100.000', 50, 100000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 200.000', 50, 200000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 300.000', 50, 300000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Vietnammobile 500.000', 50, 500000, 3, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 10.000', 50, 10000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 20.000', 50, 20000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 30.000', 50, 30000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 50.000', 50, 50000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 100.000', 50, 100000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 200.000', 50, 200000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 300.000', 50, 300000, 4, '2023-07-01 16:33:11', 1, false),
    ('Thẻ Mobifone 500.000', 50, 500000, 4, '2023-07-01 16:33:11', 1, false);
