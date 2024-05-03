package io.thoughtscript.subscriber.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmbeddedComponentReceiver {
    @KafkaListener(topics = "test", groupId = "io.thoughtscript")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info(consumerRecord.value().toString());
    }
}
