package com.yqc.feign.service;

import org.springframework.stereotype.Service;

/**
 * Created by yangqc on 2017/5/10.
 */
@Service
public class ComputeClientHystrix implements FeignService {

    @Override
    public String getId() {
        System.out.println("断路器!");
        return "wait!";
    }
}
