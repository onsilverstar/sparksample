import os
import findspark
findspark.init('/home/silvester/software/spark-3.0.1')
from pyspark.sql import SparkSession

from pyspark import SparkConf, SQLContext, HiveContext, SparkContext

spark = SparkSession.builder.appName("Hive_Spark_DF").master("local[*]").enableHiveSupport().config("spark.jars","/home/silvester/software/spark-3.0.1/jars/mysql-connector-java-5.1.48-bin.jar").getOrCreate()

sc=spark.sparkContext

hivec=HiveContext(sc)
#csv_df=spark.sql
#csv_df = spark.read.format("csv").option("inferSchema","true").option("header","true").load("hdfs:///user/hive/external/sql/Bank_Branch")

#print(csv_df.count())
#csv_df.show(5)
#df=spark.sql("select id, Address, rank(id) over(order by id) as rank from Bank_Branch")
#df.show()
#df.createOrReplaceTempView("test")
#df.write.format("csv").mode('overwrite').saveAsTable('Bank_Branch_Modified')
#csv_df.write.format("csv").saveAsTable("csv_df_7")
Tables=["Bank_Branch", "Customer_Types","Employees_1","Account_Types","Customer","Transactions","Accounts","Merchants"]
for table in range(len(Tables)):
    df=spark.sql("select * from"+" "+Tables[table])
    df.createOrReplaceTempView("test")
    df=spark.sql("select * from test")
    df.show()
    #df.write.format("orc").mode("overwrite").save("/user/hive/internal/sql/"+Tables[table])
    df.write.option('path',"/user/hive/internal/sql/"+Tables[table]).saveAsTable(Tables[table]+"_modified")
