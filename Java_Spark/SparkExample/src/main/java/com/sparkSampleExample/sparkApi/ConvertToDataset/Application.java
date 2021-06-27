package com.sparkSampleExample.sparkApi.ConvertToDataset;

public class Application {

	public static void main(String[] args) {

		ArrayToDataset app = new ArrayToDataset();
		app.start();
		
		CsvToDatasetHouseToDataframe apps = new CsvToDatasetHouseToDataframe();
		apps.start();
	
		WordCount wc = new WordCount();
		wc.start();
		
	}

	
}
