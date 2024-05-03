package io.thoughtscript.publisher.runner;

import io.thoughtscript.publisher.webclient.WebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class WebClientRunner implements CommandLineRunner {

    @Autowired
    WebClient webClient;

    @Override
    public void run(String... args) throws Exception {
        ExecutorService nonBlockingService = Executors.newSingleThreadExecutor();
        nonBlockingService.execute(() -> {
            webClient.post();
        });
    }
}

