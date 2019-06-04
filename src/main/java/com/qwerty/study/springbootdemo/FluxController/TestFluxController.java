package com.qwerty.study.springbootdemo.FluxController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestFluxController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Welcome to reactive world ~";
    }

}
