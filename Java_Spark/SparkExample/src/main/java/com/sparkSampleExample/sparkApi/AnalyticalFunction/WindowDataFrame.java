package com.sparkSampleExample.sparkApi.AnalyticalFunction;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.functions.col;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
public class WindowDataFrame {
public static void main(String[] args) {
	System.setProperty("hadoop.home.dir", "c:/hadoop");
	SparkSession session=SparkSession.builder().appName("window").master("local").getOrCreate();
	session.sparkContext().setLogLevel("ERROR");
	Dataset<Row> emp=session.read().csv("src/main/resources/file/sample_agg.txt").toDF("name","dep","sal");
	WindowSpec window=Window.partitionBy(col("dep")).orderBy(col("sal").desc());
	Column column_rank=rank().over(window);
	emp.select(col("name"),col("dep"),col("sal"),column_rank.as("rank")).where(col("rank").leq(2)).show();
	Column column_dense_rank=dense_rank().over(window);
	emp.select(col("name"),col("dep"),col("sal"),column_dense_rank.as("rank")).where(col("rank").leq(2)).show();
}
}