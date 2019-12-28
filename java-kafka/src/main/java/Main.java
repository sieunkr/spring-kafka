import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Main {

    private static final String TOPIC_NAME = "coffee";
    private static final String KAFKA_BROKER_IP = "192.168.19.136:9092";

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER_IP);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_NAME, "message...");

        try {
            kafkaProducer.send(producerRecord, (metadata, exception) -> {
                if (exception != null) {
                    System.out.println("exception!");
                }
            });
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            kafkaProducer.flush();
        }
    }
}
