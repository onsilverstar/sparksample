import os
from pyhive import hive
import findspark
findspark.init('/home/silvester/software/spark-3.0.1')
from pyspark.sql import SparkSession

from pyspark import SparkConf, SQLContext, HiveContext, SparkContext

spark_sql = SparkSession.builder.appName("Mysql_Spark_DF").master("local[*]").enableHiveSupport().config("spark.jars","/usr/share/java/mysql-connector-java-5.1.48-bin.jar").getOrCreate()

sc = spark_sql.sparkContext

sqlc = SQLContext(sc)

Tables=["Bank_Branch", "Customer_Types","Employees_1","Account_Types","Customer","Transactions","Accounts","Merchants"]
for table in range(len(Tables)):
    toBeSaved=spark_sql.sql("select * from"+" "+Tables[table]+"_modified")
    toBeSaved.write \
    .format("jdbc") \
    .option('url', 'jdbc:mysql://localhost:3306/Banking') \
    .option('user', 'root') \
    .option('password', 'root') \
    .option('dbTable',(Tables[table]+"_RDBMS")) \
    .save()



