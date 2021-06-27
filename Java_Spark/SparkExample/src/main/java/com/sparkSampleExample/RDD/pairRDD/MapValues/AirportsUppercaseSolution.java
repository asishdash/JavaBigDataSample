package com.sparkSampleExample.RDD.pairRDD.MapValues;

import com.sparkSampleExample.RDD.common.Utils.Utils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class AirportsUppercaseSolution {

    public static void main(String[] args) throws Exception {
    	System.setProperty("hadoop.home.dir", "C:\\hadoop\\");
        SparkConf conf = new SparkConf().setAppName("airports").setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> airportsRDD = sc.textFile("src/main/resources/file/airports.text");

        JavaPairRDD<String, String> airportPairRDD = airportsRDD.mapToPair(getAirportNameAndCountryNamePair());

        JavaPairRDD<String, String> upperCase = airportPairRDD.mapValues(countryName -> countryName.toUpperCase());

        upperCase.saveAsTextFile("out/airports_uppercase.text");
    }

    private static PairFunction<String, String, String> getAirportNameAndCountryNamePair() {
        return (PairFunction<String, String, String>) line -> new Tuple2<>(line.split(Utils.COMMA_DELIMITER)[1],
                                                                           line.split(Utils.COMMA_DELIMITER)[3]);
    }
}
