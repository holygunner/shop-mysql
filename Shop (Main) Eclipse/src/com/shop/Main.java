/*
MySQL Code:

create database shop

use shop

create table producer (id int not null auto_increment not null,name varchar(45) not null,
country varchar(45) not null, primary key(id));

create table products (id int auto_increment not null,name varchar(45) not null,
price float not null, accessibility boolean, primary key(id), product_fk int, foreign key(product_fk) references producer(id));

 */

package com.shop;

import java.sql.SQLException;

public class Main {

	static String query;
	
	public static void main(String[] args) throws SQLException {
		
        Connection.getInstance().setUser("root");
        Connection.getInstance().setPassword("nootropil");

//        query = Query.addProduct("iphone5c",800,true);


//        query = Query.countProduct();

        query = Query.orderProducts("products","name");

        System.out.println(query);
        
        Connection.getInstance().showData(query);
	       
	}

}
