package com.sparkSampleExample.RDD.Union;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SameHostsSolution {

    public static void main(String[] args) throws Exception {
    	System.setProperty("hadoop.home.dir", "C:\\hadoop\\");
        SparkConf conf = new SparkConf().setAppName("sameHosts").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> julyFirstLogs = sc.textFile("src/main/resources/file/nasa_19950701.tsv");
        JavaRDD<String> augustFirstLogs = sc.textFile("src/main/resources/file/nasa_19950801.tsv");

        JavaRDD<String> julyFirstHosts = julyFirstLogs.map(line -> line.split("\t")[0]);

        JavaRDD<String> augustFirstHosts = augustFirstLogs.map(line -> line.split("\t")[0]);

        JavaRDD<String> intersection = julyFirstHosts.intersection(augustFirstHosts);

        JavaRDD<String> cleanedHostIntersection = intersection.filter(host -> !host.equals("host"));

        cleanedHostIntersection.saveAsTextFile("out/nasa_logs_same_hosts.csv");
    }
}
