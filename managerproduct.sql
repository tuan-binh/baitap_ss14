create database managerproduct;
use managerproduct;

create table product (
    id int auto_increment primary key,
    name varchar(200),
    description varchar(200),
    price long check ( price > 0 ),
    urlImage varchar(255)
);

# delimiter //
# create procedure