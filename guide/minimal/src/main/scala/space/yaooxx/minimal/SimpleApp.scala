package space.yaooxx.minimal;

import org.apache.spark.SparkContext;
import org.apache.spark.SparkContext._;
import org.apache.spark.SparkConf;

object SimpleApp {

  def main(args: Array[String]) {

    // val conf = new SparkConf().setAppName("SimpleApp")
    val conf = new SparkConf().setAppName("SimpleApp").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val logFile = "hdfs://localhost:9000/README.md"
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }

}
