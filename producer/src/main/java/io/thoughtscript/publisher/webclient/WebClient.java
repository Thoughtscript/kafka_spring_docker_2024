package io.thoughtscript.publisher.webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class WebClient {

    public void post() {
        try {
            while (true) {
                org.springframework.web.reactive.function.client.WebClient
                        .create()
                        .post()
                        .uri("http://consumer:8080/api/test")
                        .bodyValue(new CustomRequestBody("webclient message"))
                        .retrieve()
                        .toEntity(CustomResponse.class).flatMap(responseEntity -> {
                            log.info("WebClient message sent!");
                            //log.info(responseEntity.toString());
                            //log.info(responseEntity.getBody().getMessage());
                            return Mono.empty();
                        })
                        .block();

                Thread.sleep(5000);
            }
        } catch (InterruptedException ex) {
            log.error(ex.getMessage());
        }
    }
}
