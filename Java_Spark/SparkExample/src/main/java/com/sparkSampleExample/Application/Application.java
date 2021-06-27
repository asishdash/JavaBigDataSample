package com.sparkSampleExample.Application;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.SparkSession;

public class Application {

	
	public static void main(String args) {
		
	}
	
	
	public SparkSession implamentSparkSession( String name) {
		System.setProperty("hadoop.home.dir", "C:\\hadoop\\");
        Logger.getLogger("org").setLevel(Level.ERROR);
		SparkSession spark = SparkSession.builder()
		        .appName(name)
		        .master("local")
		        .getOrCreate();
		return spark;
		
	}
	
	public void implamentSparkSessionClose( SparkSession spark) {
		spark.close();;
	}
	
	
	public void implementSparkContext() {
		
	}
}
