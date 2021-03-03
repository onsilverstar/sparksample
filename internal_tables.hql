DROP TABLE IF EXISTS Account_Types_Modified;
create table Account_Types_Modified(id int,name string)
stored by 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
with serdeproperties("hbase.columns.mapping"=":key,x:name");

insert overwrite table Account_Types_Modified
select * from Account_Types where id<4;
select * from Account_Types_Modified;

DROP TABLE IF EXISTS Customer_Modified;
create table Customer_Modified(name varchar(40), id int, name2 varchar(40), phone varchar(40))
stored by 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
with serdeproperties("hbase.columns.mapping"="x:name,:key, x:name2, x:phone");

insert overwrite table Customer_Modified
select * from customer where id<4;
select * from Customer_Modified;

DROP TABLE IF EXISTS Employees1;
create table Employees1(id int, name varchar(40), salary varchar(40), rank int)
stored by 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
with serdeproperties("hbase.columns.mapping"=":key, x:name, x:salary, x:rank");


insert overwrite table Employees1
select id, name, salary, rank(*) over(order by salary) rank from Employees_1 where id<4;
select * from Employees1;


DROP TABLE IF EXISTS Products_Services_Modified;
create table Products_Services_Modified(id int,name string)
stored by 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
with serdeproperties("hbase.columns.mapping"=":key,x:name");

insert overwrite table Products_Services_Modified
select * from Products_Services where id<120;
select * from Products_Services_Modified;




