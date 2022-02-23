package br.com.springkafka.producer;


import br.com.springkafka.Car;
import br.com.springkafka.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarProducer {

    private final String topic;
    private final KafkaTemplate<String, Car> kafkaTemplate;

    public CarProducer(@Value("${topic.name}")String topic, KafkaTemplate<String, Car> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Car car){
        kafkaTemplate.send(topic, car).addCallback(
                success -> log.info("Message success"),
                failure -> log.error("Message failure")
        );
    }
}
