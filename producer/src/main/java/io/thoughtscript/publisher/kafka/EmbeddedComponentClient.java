package io.thoughtscript.publisher.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class EmbeddedComponentClient {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }

    public void loopSend() {
        try {
            while (true) {
                kafkaTemplate.send("test", "hello1");
                kafkaTemplate.send("test", "hello2");
                kafkaTemplate.send("test", "hello3");
                kafkaTemplate.send("test", "hello4");
                Thread.sleep(10000);
                log.info("Kafka message sent!");
            }
        } catch (InterruptedException ex) {
            log.error(ex.getMessage());
        }
    }
}
