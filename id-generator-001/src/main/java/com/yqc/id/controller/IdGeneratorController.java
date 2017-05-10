package com.yqc.id.controller;

import com.yqc.id.id.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangqc on 2017/5/4.
 */
@RestController
@Slf4j
public class IdGeneratorController {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private EurekaRegistration registration;

    @GetMapping("/getId")
    public String getId() {
        log.debug(registration.getServiceId() + "==" + registration.getNonSecurePort());
        return "我是A： " + idGenerator.generateId();
    }
}
