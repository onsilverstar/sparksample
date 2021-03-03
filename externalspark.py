import os
from pyhive import hive
import findspark
findspark.init('/home/silvester/software/spark-3.0.1')
from pyspark.sql import SparkSession

from pyspark import SparkConf, SQLContext, HiveContext, SparkContext

spark = SparkSession.builder.appName("Mysql_Spark_DF").master("local[*]").enableHiveSupport().config("spark.jars","/usr/share/java/mysql-connector-java-5.1.48-bin.jar").getOrCreate()

sc = spark.sparkContext

sqlc = SQLContext(sc)

hivec=HiveContext(sc)
print(sc)
print(hivec)

# spark.set("spark.jars","/home/hadoop/spark/jars/postgresql-42.2.11.jar")


# df = spark.read \
#     .format("jdbc") \
#     .option("url", "jdbc:postgresql://localhost:5432/databasename") \
#     .option("dbtable", "tablename") \
#     .option("user", "username") \
#     .option("password", "password") \
#     .option("driver", "org.postgresql.Driver") \
#     .load()
#
# df.printSchema()
Tables=["Bank_Branch", "Customer_Types","Employees_1","Account_Types","Customer","Transactions","Accounts","Merchants"]
for table in range(len(Tables)):
    rdbms_df = spark.read \
    .format("jdbc") \
    .option('url', 'jdbc:mysql://localhost:3306/Banking') \
    .option('user', 'root') \
    .option('password', 'root') \
    .option('dbTable',str(Tables[table])) \
    .load()
    # parq_df.show(5)
    rdbms_df.show(500)
    rdbms_df.createOrReplaceTempView("temp_tab")
    df = spark.sql("select * from temp_tab")
    df.write.format("orc").mode("overwrite").save("/user/hive/external/sql/"+Tables[table])
    df.write.option('path',"/user/hive/external/sql/"+Tables[table]).saveAsTable(Tables[table])

