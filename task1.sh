#!/bin/bash
echo "hello"
echo "now deleting old tables......"
hive -f /home/silvester/Data/deletetables.hql
echo "now cleaning up hdfs...."
hdfs dfs -rm -r /user/hive/warehouse/*
hdfs dfs -rm -r /user/hive/external/*
hdfs dfs -rm -r /user/hive/internal/*
echo "starting spark job....."
spark-submit /home/silvester/Data/externalspark.py
echo "spark job completed and exited gracefully"
