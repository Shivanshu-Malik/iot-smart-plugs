package kafka.producer
import scala.io.Source

object KafkaFileStreamApp extends App{
  println("Entering Application")

  val bufferedStream = Source.fromFile("src/main/resources/data.csv")
  val producer = new KafkaFileStreamProducer
  for(line<-bufferedStream.getLines()){
    producer.send("test",line)
  }
  println("Exiting Application")
}
