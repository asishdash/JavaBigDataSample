package com.sparkSampleExample.sparkApi.read_csv_json;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JSON_MULTILINE_PARSER_DEMO {
	
	public void parseMultiLineJsonLines(SparkSession spark) {
	   
	 
	    Dataset<Row> df = spark.read().format("json")
	    	//.option("multiline", true)
	        .load("src/main/resources/file/multiline.json");
	        
	    df.show(5, 150);
	    df.printSchema();
	  }
	
	
	public void parseSimpleJsonLines(SparkSession spark) {
	  
	    
	    Dataset<Row> df = spark.read().format("json")
		        .load("src/main/resources/file/simple.json");
	 
	    df.show(5, 150);
	    df.printSchema();
	  }

}
