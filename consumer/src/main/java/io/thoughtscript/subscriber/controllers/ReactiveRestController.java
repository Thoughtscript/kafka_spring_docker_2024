package io.thoughtscript.subscriber.controllers;

import io.thoughtscript.subscriber.dto.CustomRequestBody;
import io.thoughtscript.subscriber.dto.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ReactiveRestController {

    @PostMapping("/api/test")
    public Mono<CustomResponse> post(@RequestBody CustomRequestBody requestBody) {
        log.info(requestBody.getMessage());
        return Mono.just(new CustomResponse(200, "success"));
    }

    @GetMapping("/api/test")
    public Mono<CustomResponse> get() {
        return Mono.just(new CustomResponse(200, "success"));
    }
}