package com.sparkSampleExample.sparkApi.read_csv_json;

import org.apache.spark.sql.SparkSession;

import com.sparkSampleExample.Application.Application;

public class Read_CSV_Json_With_Schema_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Schema Demo";
		Application app = new Application();
		SparkSession spark = getSparkInstance(app, name);
		read_csv_defined_schema(spark);
		parseMultiLineJsonLines(spark);
		parseSimpleJsonLines(spark);
		closeSparkSession( spark , app);
		

	}
	
	public static void  read_csv_defined_schema(SparkSession spark) {
		
		Initlaize_CSV_Schema parserCsv = new Initlaize_CSV_Schema();
		parserCsv.printDefinedSchema(spark);
		
	}
	
	 public static void parseSimpleJsonLines (SparkSession spark) {
		 JSON_MULTILINE_PARSER_DEMO parserMultiLineJson = new JSON_MULTILINE_PARSER_DEMO();
		 parserMultiLineJson.parseSimpleJsonLines(spark);
	 }
	
   public static void  parseMultiLineJsonLines(SparkSession spark) {
		
	   JSON_MULTILINE_PARSER_DEMO parserMultiLineJson = new JSON_MULTILINE_PARSER_DEMO();
	   parserMultiLineJson.parseMultiLineJsonLines(spark);
		
	}
	
	
	public static SparkSession getSparkInstance(Application app, String name) {
		
		SparkSession spark = app.implamentSparkSession(name);
		return spark;
	
	}
	
	
	public static void closeSparkSession(SparkSession spark , Application app) {
		
		app.implamentSparkSessionClose(spark);
		
	}

}
