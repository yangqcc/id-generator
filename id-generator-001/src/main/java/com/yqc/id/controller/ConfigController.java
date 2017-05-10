package com.yqc.id.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangqc on 2017/5/10.
 */
@RefreshScope
@RestController
public class ConfigController {

  /*  @Value("${foo}")
    private String from;

    @RequestMapping("/foo")
    public String foo() {
        return this.from;
    }*/

}
