package io.thoughtscript.publisher.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import io.thoughtscript.publisher.kafka.EmbeddedComponentClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class KafkaRunner implements CommandLineRunner {

    @Autowired
    EmbeddedComponentClient embeddedComponentClient;

    @Override
    public void run(String... args) throws Exception {
        ExecutorService nonBlockingService = Executors.newSingleThreadExecutor();
        nonBlockingService.execute(() -> {
            embeddedComponentClient.loopSend();
        });
    }
}
