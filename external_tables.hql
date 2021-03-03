DROP TABLE IF EXISTS Account_Types;
create external table Account_Types (id int, name varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Account_Types';
Select * from Account_Types;

DROP TABLE IF EXISTS Customer;
create external table Customer (name varchar(40), id int, name2 varchar(40), phone varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Customer';
select* from Customer;

DROP TABLE IF EXISTS Customer_Types;
create external table Customer_Types (id int, name varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Customer_Types';
select* from Customer_Types;

DROP TABLE IF EXISTS Transactions;
create external table Transactions(id int, description varchar(40), trans_id int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Transactions';
select* from Transactions;

DROP TABLE IF EXISTS Employees_1;
create external table Employees_1 (id int, name varchar(40), salary varchar(40)) 
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Employees_1';
select * from Employees_1;

DROP TABLE IF EXISTS Bank_Branch;
create external table Bank_Branch (address varchar(40), id int) 
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Bank_Branch';
select* from Bank_Branch;

DROP TABLE IF EXISTS Accounts;
create external table Accounts (id int, name varchar(40), cust_id int, date_opened Date) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Accounts';
select * from Accounts;

DROP TABLE IF EXISTS Merchants;
create external table Merchants (name varchar(40), id int, phone varchar(40), email varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hive/external/Merchants';
select * from Merchants;

DROP TABLE IF EXISTS Products_Services;
create external table Products_Services (id int, name varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/oracle/PRODUCTS_SERVICES';
select * from Products_Services;

DROP TABLE IF EXISTS Transaction_Types;
create external table Transaction_Types(id int,description varchar(40)) ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/postgres/transaction_types';
select * from Transaction_Types;