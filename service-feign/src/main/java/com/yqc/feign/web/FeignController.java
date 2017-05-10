package com.yqc.feign.web;

import com.yqc.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping(value = "/getId")
    public String getId() {
        String id = feignService.getId();
        System.out.println(id);
        return id;
    }
}
