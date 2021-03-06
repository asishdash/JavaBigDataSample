package com.sparkSampleExample.sparkApi.read_csv_json;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Infer_CSV_SCHEMA {
	
	public void DeclareInferSchema() {
		SparkSession spark = SparkSession.builder()
		        .appName("Complex CSV to Dataframe")
		        .master("local")
		        .getOrCreate();
		 
		    Dataset<Row> df = spark.read().format("csv")
		        .option("header", "true") //
		        .option("multiline", true) //
		        .option("sep", ";") //
		        .option("quote", "^") //
		        .option("dateFormat", "M/d/y") //
		        .option("inferSchema", true) //
		        .load("src/main/resources/file/amazonProducts.txt");
		 
		    System.out.println("Excerpt of the dataframe content:");
		    df.show(7, 90); // truncate after 90 chars
		    System.out.println("Dataframe's schema:");
		    df.printSchema();
	}

}
