#!/bin/bash

echo "hello"

Tables="Bank_Branch
Customer_Types
Employees_1
Account_Types
Customer
Transactions
Accounts
Merchants"

for table in $Tables
    do
    echo "creating table $table"
    sqoop import --connect jdbc:mysql://localhost:3306/Banking --username root --password root --table $table -m 1 --target-dir /user/sql/$table
    done
echo "completed for mysql"

sqoop import --connect jdbc:postgresql://localhost:5432/postgres --username postgres --password postgres --table transaction_types -m 1 --target-dir /user/postgres/transaction_types

sqoop import --connect jdbc:oracle:thin:@localhost:1521:xe --username system -password oracle --table HR.PRODUCTS_SERVICES -m 1 --target-dir /user/oracle/PRODUCTS_SERVICES