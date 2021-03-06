package com.sparkSampleExample.sparkApi.read_csv_json;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class Initlaize_CSV_Schema {

	public void printDefinedSchema(SparkSession spark) {
		
        
        StructType schema = DataTypes.createStructType(new StructField[] { //
	            DataTypes.createStructField(
	                "id", //
	                DataTypes.StringType, //
	                false), //
	            DataTypes.createStructField(
	                "product_id",
	                DataTypes.StringType,
	                true),
	            DataTypes.createStructField(
	                "item_name",
	                DataTypes.StringType,
	                false),
	            DataTypes.createStructField(
	                "published_on",
	                DataTypes.DateType,
	                true),
	            DataTypes.createStructField(
	                "url",
	                DataTypes.StringType,
	                false) });
	     
	        Dataset<Row> df = spark.read().format("csv")
	            .option("header", "true")
	            .option("multiline", true)
	            .option("sep", ";")
	            .option("dateFormat", "M/d/y")
	            .option("quote", "^")
	            .schema(schema) //
	            .load("src/main/resources/file/amazonProducts.txt");
	     
	        df.show(5, 15);
	        df.printSchema();
		
	}

}
