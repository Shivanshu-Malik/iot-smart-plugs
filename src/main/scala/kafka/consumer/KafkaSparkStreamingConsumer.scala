package kafka.consumer


import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils

object KafkaSparkStreamingConsumer extends App{
  val brokers = "localhost:9092"
  val sparkConf = new SparkConf().setAppName("KafkaDirectStreaming").setMaster("local[2]")
  val ssc = new StreamingContext(sparkConf, Seconds(10))
  ssc.checkpoint("checkpointDir")
  val topicsSet = Set("test")
  val kafkaParams = Map[String, String]("metadata.broker.list" -> brokers, "group.id" -> "spark_streaming")
  val messages: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topicsSet)
  val fileLines: DStream[String] = messages.map { case (key, message) => message }
  fileLines.print()

  ssc.start()
  ssc.awaitTermination()

}
