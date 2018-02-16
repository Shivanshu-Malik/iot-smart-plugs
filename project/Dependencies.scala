import sbt._
object Dependencies {
  val kafka = "org.apache.kafka" % "kafka-clients" % "1.0.0"
  val sparkCore = "org.apache.spark" %% "spark-core" % "2.2.0"
  val sparkStreaming = "org.apache.spark" %% "spark-streaming" % "2.2.0"
  val sparkSQL = "org.apache.spark" %% "spark-sql" % "2.2.0"
  val sparkKafka = "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"

}
