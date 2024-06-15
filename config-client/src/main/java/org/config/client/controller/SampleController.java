package org.config.client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.config.client.config.SampleConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SampleController {

    private final SampleConfig sampleConfig;

//    @Value("${app1.sample.message}")
//    private String message;

    @Value("${app2.profile.userName}")
    private String userName;

    @GetMapping("/config/app1")
    public ResponseEntity<String> configApp1() {
        log.info("{}", sampleConfig);
        //log.info("{}", message);
        return ResponseEntity.ok(sampleConfig.toString());
    }

    @GetMapping("/config/app2")
    public ResponseEntity<String> configApp2() {
        log.info("{}", userName);
        return ResponseEntity.ok(userName);
    }
}
